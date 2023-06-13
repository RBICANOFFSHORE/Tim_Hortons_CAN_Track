package com.testcases.framework;

import com.reuseablecomponents.framework.ReUseableMethods;
import com.setup.framework.TestCaseName;
import com.testcases.framework.baseTestCase.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.lang.annotation.Annotation;

@TestCaseName(name = "My Second Test Case")
public class SecondsTestCase extends BaseTestCase {
    WebDriver wd;
    ReUseableMethods md;

    @Test
    public void test(){
        try{
            wd = getCustomDriver();
            md = getReUsableMethods(wd);

            report.addTest(getTestName("com.testcases.framework.SecondsTestCase"));
            status = md.getURL(wd,"http://www.google.com");
            report.addTestStep("Get URL", "getURL", status, null);
            status = methods.customWait(2);
            report.addTestStep("Hard Wait", "customWait", status, null);
            report.addTestStep("Hard Wait", "customWait", "Pass", null);
            report.addTestStep("Hard Wait", "customWait", "Fail", null);
        }catch (Exception ex){
            upDateLog("Exception in Second Test Case" + "\n" + ex.toString());
        }finally {
            wd.quit();
            report.closeReport();
        }
    }
}
