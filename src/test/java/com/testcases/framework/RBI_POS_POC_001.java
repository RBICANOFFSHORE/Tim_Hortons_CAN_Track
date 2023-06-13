package com.testcases.framework;

import com.testcases.framework.baseTestCase.BaseTestCase;
import com.reuseablecomponents.framework.ReUseComp;
import com.reuseablecomponents.framework.ReUseableMethods;
import com.setup.framework.TestCaseName;
import com.testcases.framework.baseTestCase.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.function.Consumer;

@TestCaseName(name = "RBI POS Ordering")
public class RBI_POS_POC_001 extends BaseTestCase {
    WebDriver wd;
    ReUseableMethods md;
    @Test(retryAnalyzer = com.util.framework.ReTry.class)
    public void posPOCTestCase(){
        try{
            long startTime = System.currentTimeMillis();
            wd = getCustomDriver();
            report.addTest(getTestName("com.testcases.framework.RBI_POS_POC_001"));

            Consumer<WebDriver> con = X-> ReUseComp.rbiPOSLogin(wd);
            Consumer<WebDriver> lunchDinner = Y-> ReUseComp.rbiPOSSelectLunchDinner(wd);
            Consumer<WebDriver> whopper = Y-> ReUseComp.rbiPOSSelecWhoppers(wd);
            Consumer<WebDriver> sub_whopper = Y-> ReUseComp.rbi_POS_SelecSub_Menu_Whoppers(wd);
            Consumer<WebDriver> modifiers = Y-> ReUseComp.rbi_POS_Whopper_Cheese_Pickle_Tomato(wd);
            Consumer<WebDriver> total = Y-> ReUseComp.rbi_POS_Total(wd);
            Consumer<WebDriver> cash = Y-> ReUseComp.rbi_POS_Cash(wd);
            Consumer<WebDriver> kdsvalidation = Y-> ReUseComp.rbiPOS_KDS_Open(wd);
            con.andThen(lunchDinner)
                    .andThen(whopper)
                    .andThen(sub_whopper)
                    .andThen(modifiers)
                    .andThen(total)
                    .andThen(cash)
                    .andThen(kdsvalidation)
                    .accept(wd);

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            upDateLog("Total time taken " + elapsedTime/1000 + " Seconds");
        }
        catch (Exception ex)
        {
            upDateLog("Exception in RBIContent" + "\n" + ex.toString());
        }finally {
            wd.quit();
            report.closeReport();
        }
    }
}