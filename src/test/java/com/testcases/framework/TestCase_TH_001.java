package com.testcases.framework;

import com.reuseablecomponents.framework.ReUseComp;
import com.reuseablecomponents.framework.ReUseableMethods;
import com.setup.framework.TestCaseName;
import com.testcases.framework.baseTestCase.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.function.Consumer;

@TestCaseName(name = "Login with valid credentials")
public class TestCase_TH_001 extends BaseTestCase{
    WebDriver wd;
    ReUseableMethods md;
    @Test(retryAnalyzer = com.util.framework.ReTry.class)
    public void rpinCreateAnEmployee(){
        try{
            long startTime = System.currentTimeMillis();
            wd = getCustomDriver();
            report.addTest(getTestName("com.testcases.framework.TestCase_TH_001"));
            
            Consumer<WebDriver> launchUrl = X-> ReUseComp.th_launchUrl(wd);
            Consumer<WebDriver> enterPass = X-> ReUseComp.th_enter_app_password(wd);
            Consumer<WebDriver> clickSubmit = X-> ReUseComp.th_clickSubMitBtn(wd);
            Consumer<WebDriver> clickApply = X-> ReUseComp.th_clickApplyBtn(wd);

            launchUrl
                    .andThen(enterPass)
                    .andThen(clickSubmit)
                    .andThen(clickApply)
                    .accept(wd);


            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            upDateLog("Total time taken for TestCaserPin001 " + elapsedTime/1000 + " Seconds");

        }catch (Exception ex){
            upDateLog("Exception in rpin Create an user" + "\n" + ex.toString());
        }finally {
            wd.quit();
            report.closeReport();
        }
    }
}
