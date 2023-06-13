package com.testcases.framework;

import com.reuseablecomponents.framework.ReUseComp;
import com.reuseablecomponents.framework.ReUseableMethods;
import com.setup.framework.TestCaseName;
import com.testcases.framework.baseTestCase.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.function.Consumer;

@TestCaseName(name = "RBI Content Only PLU Update")
public class RBI_Content_PLU_Modification extends BaseTestCase {
    WebDriver wd;
    ReUseableMethods md;

    @Test(retryAnalyzer = com.util.framework.ReTry.class)
    public void modifyRBIPLU(){
        try{
            long startTime = System.currentTimeMillis();
            wd = getCustomDriver();
            report.addTest(getTestName("com.testcases.framework.RBI_Content_PLU_Modification"));
            Consumer<WebDriver> con = X-> ReUseComp.rbiLogin(wd);
            Consumer<WebDriver> conSearch = X-> ReUseComp.rbiContentSearch(wd);
            Consumer<WebDriver> createDuplicate = X-> ReUseComp.createDuplicate(wd);
            Consumer<WebDriver> delete = X-> ReUseComp.delete(wd);
            Consumer<WebDriver> getOffer = X-> ReUseComp.getOffer(wd);
            Consumer<WebDriver> updateOfferName = X-> ReUseComp.upDateOfferName(wd, testData.getTestData("QA"));
            Consumer<WebDriver> updateOfferHeaderText = X-> ReUseComp.upDateOfferHeaderSuperText(wd, testData.getTestData("QA"));
            Consumer<WebDriver> updateOfferImgDesc = X-> ReUseComp.upDateOfferImageDesc(wd, testData.getTestData("QA"));
            Consumer<WebDriver> updateOfferShortCode = X-> ReUseComp.upDateOfferShortCode(wd, testData.getTestData("QA"));
            Consumer<WebDriver> updateOfferPrice = X-> ReUseComp.upDateOfferPrice(wd, testData.getTestData("QA"));
            Consumer<WebDriver> updateOfferDescription = X-> ReUseComp.upDateOfferDescription(wd, testData.getTestData("QA"));
            Consumer<WebDriver> updateOfferMoreInfo = X-> ReUseComp.upDateOfferMoreInfo(wd, testData.getTestData("QA"));
            Consumer<WebDriver> updateOfferHowToReDeem = X-> ReUseComp.upDateOfferHowToReDeem(wd, testData.getTestData("QA"));
            Consumer<WebDriver> updateOfferUIPatterns = X-> ReUseComp.rbiContentUIPatternSelectStandardOffer(wd);
            Consumer<WebDriver> updateOfferRedemptionMethods = X-> ReUseComp.rbiContentRedemptionMethodsMobile(wd);
            Consumer<WebDriver> sicom = X-> ReUseComp.vendorConfigSicom(wd, "QA");
            Consumer<WebDriver> sicomDelivery = X-> ReUseComp.vendorConfigSicomDelivery(wd, "QA");
            Consumer<WebDriver> ncr = X-> ReUseComp.vendorConfigNCR(wd, "QA");
            Consumer<WebDriver> ncrDelivery = X-> ReUseComp.vendorConfigNCRDelivery(wd, "QA");
            Consumer<WebDriver> carrols = X-> ReUseComp.vendorConfigCarrols(wd, "QA");
            Consumer<WebDriver> rulesetDelete = X-> ReUseComp.ruleSetDelete(wd);
            Consumer<WebDriver> rulesetAddAnd = X-> ReUseComp.ruleSet_Add_And_Limit(wd, "QA");
            Consumer<WebDriver> option = X-> ReUseComp.option_Select_First(wd);


            con.andThen(conSearch).andThen(createDuplicate)
                    .andThen(updateOfferName)
                    .andThen(updateOfferHeaderText)
                    .andThen(updateOfferImgDesc)
                    .andThen(sicom)
                    .andThen(sicomDelivery)
                    .andThen(ncr)
                    .andThen(ncrDelivery)
                    .andThen(carrols)
                    .andThen(delete)
                    .accept(wd);

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            upDateLog("Total time taken " + elapsedTime/1000 + " Seconds");

        }catch (Exception ex){
            upDateLog("Exception in RBI_Content_PLU_Modification" + "\n" + ex.toString());
        }finally {
            wd.quit();
            report.closeReport();
        }
    }
}
