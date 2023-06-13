package com.testcases.framework;

import com.pages.framework.HomePage;
import com.reuseablecomponents.framework.ReUseableMethods;
import com.setup.framework.TestCaseName;
import com.testcases.framework.baseTestCase.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@TestCaseName(name = "My First Test Case to check how system works under test")
public class FirstTestCase extends BaseTestCase {
    WebDriver wd;
    ReUseableMethods md;
    HomePage page = new HomePage();
    @Test
    public void geturl(){
        try{
            wd = getCustomDriver();
            md = getReUsableMethods(wd);

            report.addTest(getTestName("com.testcases.framework.FirstTestCase"));
            methods = new ReUseableMethods(wd);
            status = methods.getURL(wd,testData.getTestData("AURL"));
            report.addTestStep("Get URL " + testData.getTestData("AURL"), "getURL", status, null);
            status = methods.customWait(4);
            report.addTestStep("Hard Wait", "customWait", status, null);
            status = methods.enterData(wd, page.domainstartURL, testData.getTestData("testURL"));
            report.addTestStep("Entered Test 2 URL" + testData.getTestData("testURL"), "enterData", status, null);

            status = methods.customWait(4);
            report.addTestStep("Hard Wait", "customWait", status, null);

            String parentWindow = wd.getWindowHandle();

            status = methods.click(wd, page.connect);
            report.addTestStep("Clicked on connect button", "click", status, null);
            status = methods.customWait(20);
            report.addTestStep("Hard Wait", "customWait", status, null);

            status = methods.windowHandleChild(wd, parentWindow);
            report.addTestStep("Move to BWW Site", "windowHandle", status, null);

            status = methods.waitCustom(wd, page.menu);
            report.addTestStep("Waiting for Menu Text", "waitCustom", status, null);

            status = methods.windowHandleParent(wd, parentWindow);
            report.addTestStep("Moved to parent window", "windowHandleParent", status, null);

            status = methods.waitCustom(wd, page.continueTags);
            report.addTestStep("Waiting for Continue button", "waitCustom", status, null);

            status = methods.click(wd, page.continueTags);
            report.addTestStep("Clicked on Continue button", "click", status, null);

            status = methods.click(wd, page.clearTags);
            report.addTestStep("Cleared all value in Tags window", "click", status, null);

            status = methods.customWait(10);
            report.addTestStep("Hard Wait 10 secs", "customWait", status, null);
        }catch (Exception ex){
            upDateLog("Unable to complete. Please check the log." + "\n" + ex.toString());

        }finally {
            wd.quit();
            report.closeReport();
        }
    }
}
