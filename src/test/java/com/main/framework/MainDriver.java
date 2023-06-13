package com.main.framework;

import com.setup.framework.TestWD;
import com.util.framework.CustomLog;
import com.util.framework.ILog;
import com.util.framework.ProxyClass;
import com.util.framework.ReadFromProperties;
import org.openqa.selenium.WebDriver;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class MainDriver extends ReadFromProperties {

    public static void main(String[] args) {

        try {
            /*
                This code creates TestNG Suite XML on Runtime based on TestSetup.xml
                Here we have used xmlSuite, xmlTest, parallel etc
                This will simplify overall execution by just executing TestNG on runtime
                Advantage of TestNG like re-try process also custom xml integration with Jenkins can be used

            */

            String parallelExecution = getFromProperties("Parallel");
            XmlSuite testSuite = new XmlSuite();
            testSuite.setName("TestExecution");
            if (parallelExecution.equalsIgnoreCase("No")) {
                testSuite.setParallel(XmlSuite.ParallelMode.NONE);
            } else {
                testSuite.setParallel(XmlSuite.ParallelMode.CLASSES);
            }
            testSuite.setVerbose(1);
            XmlTest xmlTest = new XmlTest(testSuite);
            xmlTest.setName("AutomationExecution");
            xmlTest.setPreserveOrder(true);
            List<XmlClass> testClasses = new ArrayList<XmlClass>();
            /*
              This code reads the TestSetup.xml file and execute test based on run flag
              If you modify or add new test cases then make sure you update TestSetup.xml file
            */
            DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = builder.newDocumentBuilder();
            Document doc = db.parse(new File((String) getFromProperties("Setup")));
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            NodeList nList = doc.getElementsByTagName("testname");
            for (int I = 0; I < nList.getLength(); I++) {
                Node node = nList.item(I);
                Element eElement = (Element) node;
                String testName = eElement.getAttribute("name");
                String runFlag = eElement.getAttribute("run");
                if (runFlag.contains("yes")) {
                    XmlClass publicTestClass = new XmlClass(testName);
                    testClasses.add(publicTestClass);
                }
            }
            xmlTest.setXmlClasses(testClasses);
            TestNG testNG = new TestNG();
            List<XmlSuite> testSuites = new ArrayList<XmlSuite>();
            testSuites.add(testSuite);
            testNG.setXmlSuites(testSuites);
            testNG.run();
        } catch (Exception ex) {
            upDateLog("Exception in main driver. Please check all the setup and try again" + "\n" + ex.toString());
        } finally {
            upDateLog("Test Execution finished.");
        }
    }
}