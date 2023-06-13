package com.testcases.framework.baseTestCase;

import com.reports.framework.Report;
import com.reuseablecomponents.framework.ReUseableMethods;
import com.setup.framework.TestCaseName;
import com.setup.framework.TestWD;
import com.util.framework.DriverSupplier;
import com.util.framework.GetTestData;
import com.util.framework.ReadFromProperties;
import org.openqa.selenium.WebDriver;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class BaseTestCase extends ReadFromProperties {

    public static Report report = new Report();
    public static WebDriver wd;
    public static String status;
    public static ReUseableMethods methods;
    public static GetTestData testData = new GetTestData();
    public static List list = new ArrayList();

    public String getTestName(String classNameWithPackageName){
        try{

            Class<?> clazz = Class.forName(classNameWithPackageName);
            Object testClassName = clazz.getDeclaredConstructor().newInstance();
            Class c = testClassName.getClass();
            Annotation ano = c.getAnnotation(TestCaseName.class);
            TestCaseName testcase = (TestCaseName)ano;
            return testcase.name();

        }catch (Exception ex){
            upDateLog("Exception happened while getting Test Case name from class annotations" + "\n" + ex.toString());
            return null;
        }
    }
    public static WebDriver getCustomDriver(){
        try{
            //wd = TestWD.getWD();
            wd = DriverSupplier.getChromeDriver();
            return wd;

        }catch (Exception ex){
            upDateLog("Exception happened while getting getting driver" + "\n" + ex.toString());
            return null;
        }
    }
    public static ReUseableMethods getReUsableMethods(WebDriver wd){
        try{
            return methods = new ReUseableMethods(wd);
        }catch (Exception ex){
            upDateLog("Exception happened while getting returning  ReUsableMethods" + "\n" + ex.toString());
            return null;
        }
    }
}
