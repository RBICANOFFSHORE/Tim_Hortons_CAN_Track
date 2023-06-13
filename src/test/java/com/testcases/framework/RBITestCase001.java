package com.testcases.framework;

import com.pages.framework.HomePage;
import com.pages.framework.IPage;
import com.pages.framework.RBIPage;
import com.reuseablecomponents.framework.ReUseableMethods;
import com.setup.framework.TestCaseName;
import com.testcases.framework.baseTestCase.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@TestCaseName(name = "RBI First Test Case To Check Menu")
public class RBITestCase001 extends BaseTestCase {
    WebDriver wd;
    ReUseableMethods md;

    @Test(retryAnalyzer = com.util.framework.ReTry.class)
    public void validateRBIItem(){

        try{
            wd = getCustomDriver();
            md = getReUsableMethods(wd);
            report.addTest(getTestName("com.testcases.framework.RBITestCase001"));
            status = md.getURL(wd, testData.getTestData("RBIURL"));
            report.addTestStep("Get URL " + testData.getTestData("RBIURL"), "getURL", status, null);
            status = md.customWait(2);
            report.addTestStep("Custom Wait", "customWait", status, null);
            status = md.enterData(wd, RBIPage.passwordRBI, testData.getTestData("RBIPassword"));
            report.addTestStep("Enter Password", "enterData", status, null);
            status = md.click(wd, RBIPage.submitRBI);
            report.addTestStep("Click on Submit button", "Click", status, null);

            status = md.customWait(3);
            report.addTestStep("Custom wait for 3 sec", "customWait", status, null);

            status = md.click(wd, RBIPage.canadaEnglishRBI);
            report.addTestStep("Click on Canada English", "click", status, null);

            status = md.click(wd, RBIPage.applyRBI);
            report.addTestStep("Click on Apply", "click", status, null);

            status = md.customWait(3);
            report.addTestStep("Custom wait for 3 sec", "customWait", status, null);

            status = md.click(wd, RBIPage.chooseYourLocation);
            report.addTestStep("Click on chooseYourLocation", "click", status, null);

            status = md.click(wd, RBIPage.pickUpRBI);
            report.addTestStep("Click on Pickup", "click", status, null);

            status = md.customWait(5);
            report.addTestStep("Custom wait for 5 sec", "Wait", status, null);

            status = md.enterData(wd, RBIPage.yourAddressRBI, testData.getTestData("Address1"));
            report.addTestStep("Entered address", "enterData", status, null);

            status = md.customWait(4);
            report.addTestStep("Wait for 4 sec", "customWait", status, null);

            status = md.click(wd, RBIPage.austin);
            report.addTestStep("Select 1 Austin", "click", status, null);

            status = md.customWait(5);
            report.addTestStep("Wait for 5 sec", "customWait", status, null);

            status = md.click(wd, RBIPage.austinBtn);
            report.addTestStep("Selecting Austin store", "click", status, null);

            status = md.customWait(5);
            report.addTestStep("Wait for 5 sec", "customWait", status, null);

            status = md.click(wd, RBIPage.order);
            report.addTestStep("Click on Order", "click", status, null);

            status = md.customWait(5);
            report.addTestStep("Wait for 5 sec", "customWait", status, null);

        }catch (Exception ex){
            upDateLog("Exception in RBITestCase001" + "\n" + ex.toString());
        }finally {
            wd.quit();
            report.closeReport();
        }
    }
}
