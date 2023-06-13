package com.testcases.framework;

import com.reuseablecomponents.framework.ReUseComp;
import com.reuseablecomponents.framework.ReUseableMethods;
import com.setup.framework.TestCaseName;
import com.testcases.framework.baseTestCase.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.function.Consumer;

@TestCaseName(name = "Scenario For creating an Employee")
public class TestCaserPin001 extends BaseTestCase{
    WebDriver wd;
    ReUseableMethods md;
    @Test(retryAnalyzer = com.util.framework.ReTry.class)
    public void rpinCreateAnEmployee(){
        try{
            long startTime = System.currentTimeMillis();
            wd = getCustomDriver();
            report.addTest(getTestName("com.testcases.framework.TestCaserPin001"));
            Consumer<WebDriver> con = X-> ReUseComp.rpinLogin(wd);
            Consumer<WebDriver> bkus = X-> ReUseComp.rpinSelectBKUS(wd);
            Consumer<WebDriver> bkusCreateEmployee = X-> ReUseComp.rpinBKUSCreateEmployee(wd);
            Consumer<WebDriver> searchEmployee = X-> ReUseComp.rbi_rPIM_SearchEmployee(wd);

            con
                    .andThen(bkus)
                    .andThen(bkusCreateEmployee)
                    .andThen(searchEmployee)
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
