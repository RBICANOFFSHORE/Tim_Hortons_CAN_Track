package com.reuseablecomponents.framework;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;
import com.cognizant.framework.api.GmailApiUtil;
import com.pages.framework.Elements;
import com.pages.framework.RBIPage;
import com.testcases.framework.baseTestCase.BaseTestCase;
import com.util.framework.ExcelData;

import configReader.PropertyFileReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReUseComp extends BaseTestCase {

	static WebDriver wd;
	static ReUseableMethods md;
	static String status = null;
	static String path = null;
	static Elements e = new Elements();
	static PropertyFileReader propReader=null;

	public static WebDriver th_launchUrl(WebDriver wd){
		try{
			propReader = new PropertyFileReader();
			md = getReUsableMethods(wd);
			md.getURL(wd,testData.getTestData("thurl"));
			//String path = md.takeScreenShot(wd, "");
			status = "Pass";
			report.addTestStep("Navigate to url ", "Navigate to url "+wd.getCurrentUrl(), status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiPOS_KDS_Open method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiPOS_KDS_Open");
			report.addTestStep("Navigate to url ", "Navigate to url "+wd.getCurrentUrl(), status, path);
			return null;
		}finally {
			status = null;
		}
	}

	public static WebDriver th_enter_app_password(WebDriver wd){
		try{

			md.enterData(wd, e.passwordTextBox , "rbi-tech");
			//String path = md.takeScreenShot(wd, "");
			status = "Pass";
			report.addTestStep("Enter app password", "Enter app password", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiPOS_KDS_Open method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiPOS_KDS_Open");
			report.addTestStep("Enter app password", "Enter app password", status, path);
			return null;
		}finally {
			status = null;
		}
	}

	public static WebDriver th_clickSubMitBtn(WebDriver wd){
		try{

			md.click(wd, e.submitBtn);
			//String path = md.takeScreenShot(wd, "");
			status = "Pass";
			report.addTestStep("Click submit button", "Click submit button", status, path);
			return wd;
		}catch (Exception ex){
			ex.printStackTrace();
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiPOS_KDS_Open");
			report.addTestStep("Click submit button", "Click submit button", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	
	public static WebDriver th_clickApplyBtn(WebDriver wd){
		//clicking apply button
		
				try {
					md.click(wd, e.applyBtn);
					status = "Pass";
					report.addTestStep("Click apply button", "Click appy button", status, path);
					return wd;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					report.addTestStep("Click apply button", "Click appy button", status, path);
					e1.printStackTrace();
					return null;
				}
				
	}

	public static WebDriver th_enterOtp(WebDriver wd){
		try {
			//Call OTP fetch
			md.customWait(10);
			String accessToken = GmailApiUtil.generateAccessToken(propReader.getConfigval("email"));
			String id = GmailApiUtil.findAllEmailId(accessToken);
			String Otp = GmailApiUtil.findLastReceivedEmailBody(accessToken, id).substring(140, 146);

			//entering Otp
			md.enterData(wd,e. OtpTextBox, Otp);
			status = "Pass";
			report.addTestStep("Enter Otp ", "Enter Otp ", status, path);
			wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			return wd;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			status="Fail";
			report.addTestStep("Enter Otp ", "Enter Otp ", status, path);
			e1.printStackTrace();
			return null;
		}
	}

	public WebDriver validateLogin(){
		//verify login
		try {
			wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			md.waitCustom(wd, e.accountLink);
			status="Pass";
			report.addTestStep("User Logged in", "User Logged in", status, path);
			return wd;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			report.addTestStep("User Logged in", "User Logged in", status, path);
			e1.printStackTrace();
			return null;
		}
	}

	public static WebDriver rbiPOS_KDS_Open(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.getURL(wd,testData.getTestData("RBIKDS"));
			md.customWait(10);
			String path = md.takeScreenShot(wd, "rbiPOS_KDS_Open");
			status = "Pass";
			report.addTestStep("Login to KDS and validate order id and status", "rbiPOS_KDS_Open", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiPOS_KDS_Open method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiPOS_KDS_Open");
			report.addTestStep("Login to KDS and validate order id and status", "rbiPOS_KDS_Open", status, path);
			return null;
		}finally {
			status = null;
		}
	}

	public static WebDriver rbiPOSLogin(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.getURL(wd,testData.getTestData("RBIPOSURL"));
			md.customWait(10);
			String path = md.takeScreenShot(wd, "rbiPOSLogin");
			status = "Pass";
			report.addTestStep("Login", "Login with valid UserName and Password", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiPOSLogin method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiPOSLogin");
			report.addTestStep("Login", "Login with valid UserName and Password", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rbiPOSSelectBreakFast(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.pos_BreakFast);
			md.customWait(2);
			String path = md.takeScreenShot(wd, "rbiPOSBreakFast");
			status = "Pass";
			report.addTestStep("Click on the BreakFast Menu", "rbiPOSSelectBreakFast", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiPOSBreakFast method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiPOSBreakFast");
			report.addTestStep("Click on the BreakFast Menu", "rbiPOSSelectBreakFast", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rbiPOSSelectLunchDinner(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.pos_LunchDinner);
			md.customWait(2);
			String path = md.takeScreenShot(wd, "rbiPOSLunchDinner");
			status = "Pass";
			report.addTestStep("Click on the Lunch/Dinner Menu", "rbiPOSSelectLunchDinner", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiPOSSelectLunchDinner method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiPOSLunchDinner");
			report.addTestStep("Click on the Lunch/Dinner Menu", "rbiPOSSelectLunchDinner", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rbiPOSSelecWhoppers(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.pos_Whoppers);
			md.customWait(2);
			String path = md.takeScreenShot(wd, "rbiPOSSelecWhoppers");
			status = "Pass";
			report.addTestStep("Click on the Whoppers Menu", "rbiPOSSelecWhoppers", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiPOSSelecWhoppers method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiPOSSelecWhoppers");
			report.addTestStep("Click on the Whoppers Menu", "rbiPOSSelecWhoppers", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rbi_POS_SelecSub_Menu_Whoppers(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.pos_SubmenuWhoppers);
			md.customWait(2);
			if (wd.findElements(RBIPage.pos_SubmenuWhopper_Lane).size() > 0){
				md.click(wd, RBIPage.pos_SubmenuWhopper_Lane);
			}
			md.customWait(2);
			String path = md.takeScreenShot(wd, "rbi_POS_SelecSub_Menu_Whoppers");
			status = "Pass";
			report.addTestStep("Click on the Whoppers Sub Menu Whopper", "rbi_POS_SelecSub_Menu_Whoppers", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbi_POS_SelecSub_Menu_Whoppers method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbi_POS_SelecSub_Menu_Whoppers");
			report.addTestStep("Click on the Whoppers Sub Menu Whopper", "rbi_POS_SelecSub_Menu_Whoppers", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rbi_POS_Whopper_Cheese_Pickle_Tomato(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.pos_whopper_cheese);
			md.click(wd, RBIPage.pos_whopper_pickle);
			md.click(wd, RBIPage.pos_whopper_Tomato);
			md.customWait(2);
			String path = md.takeScreenShot(wd, "rbi_POS_Whopper_Cheese_Pickle_Tomato");
			status = "Pass";
			report.addTestStep("Select Whoppers Modifiers as Cheese Pickle and Tomato", "rbi_POS_Whopper_Cheese_Pickle_Tomato", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbi_POS_Whopper_Cheese_Pickle_Tomato method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbi_POS_Whopper_Cheese_Pickle_Tomato");
			report.addTestStep("Select Whoppers Modifiers as Cheese Pickle and Tomato", "rbi_POS_Whopper_Cheese_Pickle_Tomato", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rbi_POS_Total(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.pos_whopper_Total);
			md.customWait(2);
			String path = md.takeScreenShot(wd, "rbi_POS_Total");
			status = "Pass";
			report.addTestStep("Click on the total for Whopper", "rbi_POS_Total", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbi_POS_Total method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbi_POS_Total");
			report.addTestStep("Click on the total for Whopper", "rbi_POS_Total", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rbi_POS_Cash(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.pos_whopper_Cash);
			md.customWait(3);
			md.click(wd, RBIPage.pos_whopper_Cash_Ok);
			md.customWait(3);
			String paid_Order_Id = wd.findElement(RBIPage.pos_whopper_Cash_PaidText).getText();
			String paid_Order_Total = wd.findElement(RBIPage.pos_whopper_Cash_TotalValue).getText();
			md.customWait(3);
			String path = md.takeScreenShot(wd, "rbi_POS_Cash");
			status = "Pass";
			report.addTestStep("Click on the Cash and Ok button and extract paid message and text is : " + paid_Order_Id + " Total Amount is : " + paid_Order_Total, "rbi_POS_Cash", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbi_POS_Cash method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbi_POS_Cash");
			report.addTestStep("Click on the Cash and Ok button and extract paid message and text is : NA", "rbi_POS_Cash", status, path);
			return null;
		}finally {
			status = null;
		}
	}

	public static WebDriver rpinLogin(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.getURL(wd,testData.getTestData("RPinURL"));
			md.enterData(wd, RBIPage.rpin_UserName, testData.getTestData("RPinUserName"));
			md.enterData(wd, RBIPage.rpin_Password, testData.getTestData("RPinPassword"));
			md.click(wd, RBIPage.rpin_Login);
			md.customWait(3);
			String path = md.takeScreenShot(wd, "rPinLogin");
			status = "Pass";
			report.addTestStep("Login", "Login", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rpinLogin method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rPinLogin");
			report.addTestStep("Login", "rpinLogin", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rpinSelectBKUS(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.rpin_BKUS);
			md.click(wd, RBIPage.rpin_BKUSMenu);
			md.click(wd, RBIPage.rpin_BKUSEmployees);
			String path = md.takeScreenShot(wd, "rPinBKUS");
			status = "Pass";
			report.addTestStep("Select BKUS", "rpinSelectBKUS", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rpinSelectBKUS method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rPinBKUS");
			report.addTestStep("Select BKUS", "rpinSelectBKUS", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rpinBKUSCreateEmployee(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.rpin_BKUSNewEmployee);
			md.click(wd, RBIPage.rpin_BKUSSelectAStore);
			md.customWait(3);
			md.click(wd, RBIPage.rpin_BKUSACZStore);
			md.enterData(wd, RBIPage.rpin_BKUSEmployeeCode, testData.getTestData("RPIMEmployeeCode"));
			md.enterData(wd, RBIPage.rpin_BKUSEmployeeHRCode, testData.getTestData("RPIMEmployeeHRCode"));
			md.click(wd, RBIPage.rpin_BKUSEmployeeBadgeNumber);
			md.enterData(wd, RBIPage.rpin_BKUSEmployeeName, testData.getTestData("RPIMEmployeeName"));
			md.click(wd, RBIPage.rpin_BKUSEmployeelevel);
			md.click(wd, RBIPage.rpin_BKUSEmployeelevelEmployee);
			md.click(wd, RBIPage.rpin_BKUSEmployeePayment);
			md.click(wd, RBIPage.rpin_BKUSEmployeePaymentRate);
			md.enterData(wd, RBIPage.rpin_BKUSEmployeeSalary, testData.getTestData("RPIMSalary"));
			md.click(wd, RBIPage.rPim_Admission_Calender);
			md.click(wd, RBIPage.rPim_Admission_Calender_22);
			md.click(wd, RBIPage.rPim_Termination_Calender);
			md.click(wd, RBIPage.rPim_Termination_Calender_30);
			md.click(wd, RBIPage.rPim_Birth_Calender);
			md.click(wd, RBIPage.rPim_Birth_Calender_10);
			md.click(wd, RBIPage.rPim_Expiry_Calender);
			md.click(wd, RBIPage.rPim_Termination_Calender_30);

			//md.enterData(wd, RBIPage.rpin_BKUSEmployeeAdmission, testData.getTestData("RPIMAdmission"));
			//md.enterData(wd, RBIPage.rpin_BKUSEmployeeTermination, testData.getTestData("RPIMTermination"));
			//md.enterData(wd, RBIPage.rpin_BKUSEmployeeBirth, testData.getTestData("RPIMBirth"));
			md.enterData(wd, RBIPage.rpin_BKUSEmployeeJob, testData.getTestData("RPIMJob"));
			md.enterData(wd, RBIPage.rpin_BKUSEmployeePassword, testData.getTestData("RPIMPassword"));
			md.enterData(wd, RBIPage.rpin_BKUSEmployeeRePassword, testData.getTestData("RPIMPassword"));
			//md.enterData(wd, RBIPage.rpin_BKUSEmployeeExpiry, testData.getTestData("RPIMExpiry"));
			md.click(wd, RBIPage.rpin_Save_Button);
			md.customWait(3);

			String path = md.takeScreenShot(wd, "rpinBKUSCreateEmployee");
			status = "Pass";
			report.addTestStep("Create Employee for BKUS", "rpinBKUSCreateEmployee", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rpinBKUSCreateEmployee method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rpinBKUSCreateEmployee");
			report.addTestStep("Create Employee for BKUS", "rpinBKUSCreateEmployee", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rbi_rPIM_SearchEmployee(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.rpin_BKUSSelectAStore);
			md.click(wd, RBIPage.rpin_BKUSACZStore);
			md.enterData(wd, RBIPage.rpin_GlobalSearch, testData.getTestData("RPIMEmployeeCode"));
			md.customWait(10);
			String path = md.takeScreenShot(wd, "rbi_rPIM_SearchEmployee");
			status = "Pass";
			report.addTestStep("Validate newly created employee is showing", "rbi_rPIM_SearchEmployee", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbi_rPIM_SearchEmployee method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbi_rPIM_SearchEmployee");
			report.addTestStep("Validate newly created employee is showing", "rbi_rPIM_SearchEmployee", status, path);
			return null;
		}finally {
			status = null;
		}
	}

	public static WebDriver rbiLogin(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.getURL(wd,testData.getTestData("RBIContent"));
			md.click(wd, RBIPage.emailPassword);
			md.enterData(wd, RBIPage.userName, testData.getTestData("RBIContentUserName"));
			md.enterData(wd, RBIPage.password, testData.getTestData("RBIContentPassword"));
			md.click(wd, RBIPage.logIn);
			md.customWait(3);
			String path = md.takeScreenShot(wd, "RBILogin");
			status = "Pass";
			report.addTestStep("Login", "Login", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiLogin method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "RBILogin");
			report.addTestStep("Login", "rbiLogin", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver rbiContentSearch(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.enterData(wd,RBIPage.search, testData.getTestData("RBIOffer"));
			//            for(int I = 1; I<=30; I++)
			//            {
			//                if(wd.findElement(RBIPage.rbiOffer).isDisplayed()==true)
			//                {
			//                    md.click(wd, RBIPage.rbiOffer);
			//                }else {
			//                    md.customWait(I);
			//                    System.out.println("Waiting for element for : " + I + " Seconds");
			//                }
			//            }

			md.customWait(7);
			md.click(wd, RBIPage.rbiOffer);
			status = "Pass";
			String path = md.takeScreenShot(wd, "ContentSearch");
			report.addTestStep("Content Search", "rbiContentSearch", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentSearch method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "ContentSearch");
			report.addTestStep("Content Search", "rbiContentSearch", status, path);
			return null;
		}
	}
	public static WebDriver createDuplicate(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.rbiDropDown);
			md.click(wd, RBIPage.duplicate);
			status = "Pass";
			String path = md.takeScreenShot(wd, "CreateDuplicate");
			report.addTestStep("Create Duplicate", "createDuplicate", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning createDuplicate method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "CreateDuplicate");
			report.addTestStep("Create Duplicate", "createDuplicate", status, path);
			return null;
		}
	}
	public static WebDriver delete(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.click(wd, RBIPage.rbiDropDown);
			md.click(wd, RBIPage.delete);
			md.click(wd, RBIPage.deleteNow);
			status = "Pass";
			String path = md.takeScreenShot(wd, "DeleteOffer");
			report.addTestStep("Delete Offer", "delete", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning delete method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "DeleteOffer");
			report.addTestStep("Delete Offer", "delete", status, path);
			return null;
		}
	}
	public static WebDriver getOffer(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			String text = wd.findElement(RBIPage.offerName).getText();
			//ExcelData.updateExcelData(text);
			ExcelData.insertExcelData(text);
			status = "Pass";
			String path = md.takeScreenShot(wd, "GetOffer");
			report.addTestStep("Get Offer", "getOffer", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning getOffer method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "GetOffer");
			report.addTestStep("Get Offer", "getOffer", status, path);
			return null;
		}
	}
	public static WebDriver updateOffer(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			Recordset dataSet = ExcelData.getExcelData();
			while (dataSet.next()){
				String key = dataSet.getField("ID");

			}
			status = "Pass";
			String path = md.takeScreenShot(wd, "UpdateOffer");
			report.addTestStep("Update Offer", "updateOffer", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning updateOffer method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "UpdateOffer");
			report.addTestStep("Update Offer", "updateOffer", status, path);
			return null;
		}
	}
	//This Method Updates Offer name based on the key from Excel sheet
	public static WebDriver upDateOfferName(WebDriver wd, String id){
		Connection con =null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String offername = dataSet.getField("Name");
				upDateLog(offername);
				upDateLog("Offer name to update " + offername);
				md.jsExecutorScrolll(wd, RBIPage.offerNameField);
				md.jsExecutor(wd, RBIPage.rbiOfferNameUpdate);
				WebElement elm = wd.findElement(RBIPage.rbiOfferNameUpdate);
				elm.sendKeys(Keys.COMMAND + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferNameUpdate, offername);
			}
			String path = md.takeScreenShot(wd, "UpdateOfferName");
			report.addTestStep("Updated Offer Name", "upDateOfferName", status, path);
			con.close();
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateOfferName method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "UpdateOfferName");
			report.addTestStep("Updated Offer Name", "upDateOfferName", status, path);
			return null;
		}
	}
	public static WebDriver upDateOfferHeaderSuperText(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String offerHeaderText = dataSet.getField("HeaderText");
				upDateLog("Offer Header Text to update " + offerHeaderText);
				WebElement elm = wd.findElement(RBIPage.rbiOfferHeaderText);
				elm.sendKeys(Keys.COMMAND + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferHeaderText, offerHeaderText);
			}
			String path = md.takeScreenShot(wd, "UpdateOfferHeaderText");
			report.addTestStep("Updated Offer Header Text", "upDateOfferHeaderSuperText", status, path);
			con.close();
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateOfferHeaderSuperText method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "UpdateOfferHeaderText");
			report.addTestStep("Updated Offer Header Text", "upDateOfferHeaderSuperText", status, path);
			return null;
		}
	}
	public static WebDriver upDateOfferImageDesc(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String offerImageDescription = dataSet.getField("ImageDescription");
				upDateLog("Offer Image description Text to update " + offerImageDescription);
				WebElement elm = wd.findElement(RBIPage.rbiOfferImageDesc);
				elm.sendKeys(Keys.COMMAND + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferImageDesc, offerImageDescription);
			}
			String path = md.takeScreenShot(wd, "upDateOfferImageDesc");
			report.addTestStep("Updated Offer Image Description", "upDateOfferImageDesc", status, path);
			con.close();
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateOfferImageDesc method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "upDateOfferImageDesc");
			report.addTestStep("Updated Offer Image Description", "upDateOfferImageDesc", status, path);
			return null;
		}
	}
	//This Methods Updates Short Code of the offer based on Key from Excel Data Sheet
	public static WebDriver upDateOfferShortCode(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String offerShortCode = dataSet.getField("ShortCode");
				upDateLog("Offer Short Code Text to update " + offerShortCode);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferShortCodeField);
				WebElement elm = wd.findElement(RBIPage.rbiOfferShortCode);
				elm.sendKeys(Keys.CONTROL + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferShortCode, offerShortCode);
			}
			String path = md.takeScreenShot(wd, "upDateOfferShortCode");
			report.addTestStep("Updated Offer Short Code", "upDateOfferShortCode", status, path);
			con.close();
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateOfferShortCode method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "upDateOfferShortCode");
			report.addTestStep("Updated Offer Short Code", "upDateOfferShortCode", status, path);
			return null;
		}
	}
	//This Method updates Offer Price based on key from Excel data Sheet
	public static WebDriver upDateOfferPrice(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String offerPrice = dataSet.getField("OfferPrice");
				upDateLog("Offer Price to update " + offerPrice);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferPriceField);
				WebElement elm = wd.findElement(RBIPage.rbiOfferPrice);
				elm.sendKeys(Keys.CONTROL + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferPrice, offerPrice);
			}
			String path = md.takeScreenShot(wd, "upDateOfferPrice");
			report.addTestStep("Updated Offer Price", "upDateOfferPrice", status, path);
			con.close();
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateOfferPrice method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "upDateOfferPrice");
			report.addTestStep("Updated Offer Price", "upDateOfferPrice", status, path);
			return null;
		}
	}
	//This Method Updates Offer Description Based on the Key from Excel Data Sheet
	public static WebDriver upDateOfferDescription(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String offerDescription = dataSet.getField("Description");
				upDateLog("Offer Description to update " + offerDescription);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferDescriptionField);
				md.jsExecutor(wd, RBIPage.rbiOfferDescription);
				WebElement elm = wd.findElement(RBIPage.rbiOfferDescription);
				elm.sendKeys(Keys.COMMAND + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferDescription, offerDescription);
			}
			String path = md.takeScreenShot(wd, "upDateOfferDescription");
			report.addTestStep("Updated Offer Description", "upDateOfferDescription", status, path);
			con.close();
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateOfferDescription method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "upDateOfferDescription");
			report.addTestStep("Updated Offer Description", "upDateOfferDescription", status, path);
			return null;
		}
	}
	public static WebDriver upDateOfferTags(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String offerTags = dataSet.getField("Tags");
				upDateLog("Offer Tags to update " + offerTags);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferAddTags);
				md.click(wd, RBIPage.rbiOfferAddTags);
				md.enterData(wd, RBIPage.rbiOfferAddTagsInput, offerTags);
			}
			String path = md.takeScreenShot(wd, "upDateOfferTags");
			report.addTestStep("Updated Offer Tags", "upDateOfferTags", status, path);
			con.close();
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateOfferTags method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "upDateOfferTags");
			report.addTestStep("Updated Offer Tags", "upDateOfferTags", status, path);
			return null;
		}
	}
	//This Methods Updates More Info
	public static WebDriver upDateOfferMoreInfo(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String offerMoreInfo = dataSet.getField("MoreInfo");
				upDateLog("Offer More Info to update " + offerMoreInfo);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferMoreInfoField);
				WebElement elm = wd.findElement(RBIPage.rbiOfferMoreInfo);
				elm.sendKeys(Keys.COMMAND + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferMoreInfo, offerMoreInfo);
			}
			String path = md.takeScreenShot(wd, "upDateOfferMoreInfo");
			report.addTestStep("Updated Offer More Info", "upDateOfferMoreInfo", status, path);
			con.close();
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateOfferMoreInfo method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "upDateOfferMoreInfo");
			report.addTestStep("Updated Offer More Info", "upDateOfferMoreInfo", status, path);
			return null;
		}
	}
	//This Methods Update How to Redeem
	public static WebDriver upDateOfferHowToReDeem(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String offerHowToRedeem = dataSet.getField("HowToReDeem");
				upDateLog("Offer How To Redeem to update " + offerHowToRedeem);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferHowToRedeemField);
				WebElement elm = wd.findElement(RBIPage.rbiOfferHowToRedeem);
				elm.sendKeys(Keys.CONTROL + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferHowToRedeem, offerHowToRedeem);
			}
			String path = md.takeScreenShot(wd, "upDateOfferHowToReDeem");
			report.addTestStep("Updated How to Redeem", "upDateOfferHowToReDeem", status, path);
			con.close();
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateOfferHowToReDeem method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "upDateOfferHowToReDeem");
			report.addTestStep("Updated Offer How to ReDeem", "upDateOfferHowToReDeem", status, path);
			return null;
		}
	}
	//This Method Selects UI Patterns
	public static WebDriver rbiContentUIPatternSelectStandardOffer(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferUIPatternField);
			md.selectByIndex(wd, RBIPage.rbiOfferUIPattern, 1);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentUIPatternSelectStandardOffer");
			report.addTestStep("Select UI Pattern as Standard offer", "rbiContentUIPatternSelectStandardOffer", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentUIPatternSelectStandardOffer method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentUIPatternSelectStandardOffer");
			report.addTestStep("Select UI Pattern as Standard offer", "rbiContentUIPatternSelectStandardOffer", status, path);
			return null;
		}
	}
	public static WebDriver rbiContentUIPatternSelectLockedOfferPBar(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			WebElement elm = wd.findElement(RBIPage.rbiOfferUIPattern);
			elm.sendKeys(Keys.ENTER);
			md.click(wd, RBIPage.rbiOfferUIPatternLockedOfferProgressBar);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentUIPatternSelectLockedOfferPBar");
			report.addTestStep("Select UI Pattern as Locked offer progress bar", "rbiContentUIPatternSelectLockedOfferPBar", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentUIPatternSelectLockedOfferPBar method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentUIPatternSelectStandardOffer");
			report.addTestStep("Select UI Pattern as Locked offer progress bar", "rbiContentUIPatternSelectLockedOfferPBar", status, path);
			return null;
		}
	}
	public static WebDriver rbiContentUIPatternSelectLockedOfferList(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			WebElement elm = wd.findElement(RBIPage.rbiOfferUIPattern);
			elm.sendKeys(Keys.ENTER);
			md.click(wd, RBIPage.rbiOfferUIPatternLockedOfferList);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentUIPatternSelectLockedOfferList");
			report.addTestStep("Select UI Pattern as Locked offer list", "rbiContentUIPatternSelectLockedOfferList", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentUIPatternSelectLockedOfferList method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentUIPatternSelectStandardOffer");
			report.addTestStep("Select UI Pattern as Locked offer list", "rbiContentUIPatternSelectLockedOfferList", status, path);
			return null;
		}
	}
	public static WebDriver rbiContentUIPatternSelectPromoCodeOffer(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			WebElement elm = wd.findElement(RBIPage.rbiOfferUIPattern);
			elm.sendKeys(Keys.ENTER);
			md.click(wd, RBIPage.rbiOfferUIPatternPromoCodeOffer);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentUIPatternSelectPromoCodeOffer");
			report.addTestStep("Select UI Pattern as Promo code offer7", "rbiContentUIPatternSelectPromoCodeOffer", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentUIPatternSelectPromoCodeOffer method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentUIPatternSelectPromoCodeOffer");
			report.addTestStep("Select UI Pattern as Promo code offer", "rbiContentUIPatternSelectPromoCodeOffer", status, path);
			return null;
		}
	}
	public static WebDriver rbiContentUIPatternSelectCartPromoCode(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			WebElement elm = wd.findElement(RBIPage.rbiOfferUIPattern);
			elm.sendKeys(Keys.ENTER);
			md.click(wd, RBIPage.rbiOfferUIPatternCartPromoCodeOffer);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentUIPatternSelectCartPromoCode");
			report.addTestStep("Select UI Pattern as Cart Promo Code Offer", "rbiContentUIPatternSelectCartPromoCode", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentUIPatternSelectCartPromoCode method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentUIPatternSelectCartPromoCode");
			report.addTestStep("Select UI Pattern as Cart promo code offer", "rbiContentUIPatternSelectCartPromoCode", status, path);
			return null;
		}
	}
	//This Method Selects Redemption Method as Restaurant only
	public static WebDriver rbiContentRedemptionMethodsRestaurant(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferRedemptionMethodsField);
			md.click(wd, RBIPage.rbiOfferRedemptionMethodsRestaurant);
			//md.jsExecutor(wd, RBIPage.rbiOfferRedemptionMethodsRestaurant);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentRedemptionMethodsRestaurant");
			report.addTestStep("Select Redemption Method as Restaurant", "rbiContentRedemptionMethodsRestaurant", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentRedemptionMethodsRestaurant method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentRedemptionMethodsRestaurant");
			report.addTestStep("Select Redemption Method as Restaurant", "rbiContentRedemptionMethodsRestaurant", status, path);
			return null;
		}
	}
	//This Method Selects Redemption options as Mobile Only
	public static WebDriver rbiContentRedemptionMethodsMobile(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferRedemptionMethodsField);
			//md.jsExecutor(wd, RBIPage.rbiOfferRedemptionMethodsMobile);
			md.click(wd, RBIPage.rbiOfferRedemptionMethodsMobile);
			//md.click(wd, RBIPage.rbiOfferRedemptionMethodsMobile);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentRedemptionMethodsMobile");
			report.addTestStep("Select Redemption Method as Mobile Only", "rbiContentRedemptionMethodsMobile", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentRedemptionMethodsMobile method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentRedemptionMethodsMobile");
			report.addTestStep("Select Redemption Method as Mobile Only", "rbiContentRedemptionMethodsMobile", status, path);
			return null;
		}
	}
	//This Method Selects Redemption Method as Mobile & Restaurant only
	public static WebDriver rbiContentRedemptionMethodsMobileAndRestaurant(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferRedemptionMethodsField);
			//md.jsExecutor(wd, RBIPage.rbiOfferRedemptionMethodsMobileAndRestaurant);
			md.click(wd, RBIPage.rbiOfferRedemptionMethodsMobileAndRestaurant);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentRedemptionMethodsMobileAndRestaurant");
			report.addTestStep("Select Redemption Method as Mobile & restaurant", "rbiContentRedemptionMethodsMobileAndRestaurant", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentRedemptionMethodsMobileAndRestaurant method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentRedemptionMethodsMobileAndRestaurant");
			report.addTestStep("Select Redemption Method as Mobile & Restaurant", "rbiContentRedemptionMethodsMobileAndRestaurant", status, path);
			return null;
		}
	}
	// Sicom Constant PLU Select Method
	public static WebDriver rbiContentVendorConfigSicomPLUTypeConstantPLUSelect(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			rbiContentVendorConfigOpenClose(wd);
			md.customWait(6);
			rbiContentVendorConfigSicomOpenClose(wd);
			md.customWait(5);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomPLUType);
			md.selectByIndex(wd, RBIPage.rbiOfferVendorConfigSicomPLUType,2);
			md.customWait(6);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentVendorConfigSicomPLUTypeConstantPLUSelect");
			report.addTestStep("Select Constant PLU for Sicom", "rbiContentVendorConfig", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentVendorConfigSicomPLUTypeConstantPLUSelect method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentVendorConfigSicomPLUTypeConstantPLUSelect");
			report.addTestStep("Select Constant PLU for Sicom", "rbiContentVendorConfigSicomPLUTypeConstantPLUSelect", status, path);
			return null;
		}finally {
			rbiContentVendorConfigSicomOpenClose(wd);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	public static WebDriver upDateSicomConstantPLUValue(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String pluValue = dataSet.getField("SicomConstantPLUValue");
				upDateLog("Offer SicomConstantPLUValue to update " + pluValue);
				md.customWait(3);
				rbiContentVendorConfigOpenClose(wd);
				rbiContentVendorConfigSicomOpenClose(wd);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomConstantPLUValue);
				WebElement elm = wd.findElement(RBIPage.rbiOfferVendorConfigSicomConstantPLUValue);
				elm.sendKeys(Keys.CONTROL + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferVendorConfigSicomConstantPLUValue, pluValue);
			}
			con.close();
			String path = md.takeScreenShot(wd, "upDateSicomConstantPLUValue");
			report.addTestStep("Updated Sicom Constant PLU Value", "upDateSicomConstantPLUValue", status, path);
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateSicomConstantPLUValue method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "upDateSicomConstantPLUValue");
			report.addTestStep("Updated Sicom Constant PLU Value", "upDateSicomConstantPLUValue", status, path);
			return null;
		}finally {
			rbiContentVendorConfigSicomOpenClose(wd);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	public static WebDriver rbiContentVendorConfigSicomDeliveryConstantPLUSelect(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			rbiContentVendorConfigOpenClose(wd);
			md.customWait(6);
			rbiContentVendorConfigSicomDeliveryOpenClose(wd);
			md.customWait(5);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryPLUType);
			md.click(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryPLUType);
			md.selectByIndex(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryPLUType,2);
			md.customWait(6);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentVendorConfigSicomDeliveryConstantPLUSelect");
			report.addTestStep("Click to expand Vendor Config and Select Sicom Delivery with Constant PLU", "rbiContentVendorConfigSicomDeliveryConstantPLUSelect", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentVendorConfigSicomDeliveryConstantPLUSelect method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentVendorConfigSicomDeliveryConstantPLUSelect");
			report.addTestStep("Click to expand Vendor Config and Select Sicom Delivery with Constant PLU", "rbiContentVendorConfigSicomDeliveryConstantPLUSelect", status, path);
			return null;
		}finally {
			rbiContentVendorConfigSicomDeliveryOpenClose(wd);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	public static WebDriver upDateSicomDeliveryConstantPLUValue(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String pluValue = dataSet.getField("SicomDeliveryConstantPLUValue");
				upDateLog("Offer SicomDeliveryConstantPLUValue to update " + pluValue);
				md.customWait(3);
				rbiContentVendorConfigOpenClose(wd);
				rbiContentVendorConfigSicomDeliveryOpenClose(wd);
				rbiContentVendorConfigSicomDeliveryOpenClose(wd);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryConstantPLUValue);
				WebElement elm = wd.findElement(RBIPage.rbiOfferVendorConfigSicomDeliveryConstantPLUValue);
				elm.sendKeys(Keys.CONTROL + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryConstantPLUValue, pluValue);
			}
			con.close();
			String path = md.takeScreenShot(wd, "upDateSicomDeliveryConstantPLUValue");
			report.addTestStep("Updated Sicom Delivery Constant PLU Value", "upDateSicomDeliveryConstantPLUValue", status, path);
			return wd;
		}catch (Exception ex){
			con.close();
			upDateLog("Exception while returning upDateSicomDeliveryConstantPLUValue method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "upDateSicomDeliveryConstantPLUValue");
			report.addTestStep("Updated Sicom Delivery Constant PLU Value", "upDateSicomDeliveryConstantPLUValue", status, path);
			return null;
		}finally {
			rbiContentVendorConfigSicomDeliveryOpenClose(wd);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	public static WebDriver rbiContentVendorConfigOpenClose(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfig);
			md.click(wd, RBIPage.rbiOfferVendorConfigArrowIcon);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentVendorConfigOpenClose");
			report.addTestStep("Click to expand Vendor Config", "rbiContentVendorConfigOpenClose", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentVendorConfigOpenClose method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentVendorConfigOpenClose");
			report.addTestStep("Click to expand Vendor Config", "rbiContentVendorConfigOpenClose", status, path);
			return null;
		}
	}
	public static WebDriver rbiContentVendorConfigSicomOpenClose(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicom);
			md.click(wd, RBIPage.rbiOfferVendorConfigSicom);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentVendorConfigSicomOpenClose");
			report.addTestStep("Click to expand Sicom Config", "rbiContentVendorConfigSicomOpenClose", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentVendorConfigSicomOpenClose method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentVendorConfigSicomOpenClose");
			report.addTestStep("Click to expand Sicom Config", "rbiContentVendorConfigSicomOpenClose", status, path);
			return null;
		}
	}
	public static WebDriver rbiContentVendorConfigSicomDeliveryOpenClose(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomDelivery);
			md.click(wd, RBIPage.rbiOfferVendorConfigSicomDelivery);
			status = "Pass";
			String path = md.takeScreenShot(wd, "rbiContentVendorConfigSicomDeliveryOpenClose");
			report.addTestStep("Click to expand Sicom Delivery Config", "rbiContentVendorConfigSicomDeliveryOpenClose", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning rbiContentVendorConfigSicomDeliveryOpenClose method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "rbiContentVendorConfigSicomDeliveryOpenClose");
			report.addTestStep("Click to expand Sicom Delivery Config", "rbiContentVendorConfigSicomDeliveryOpenClose", status, path);
			return null;
		}
	}
	public static WebDriver vendorConfigSicomPluTypeConstantAndValueEnter(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			rbiContentVendorConfigOpenClose(wd);
			md.customWait(4);
			rbiContentVendorConfigSicomOpenClose(wd);
			md.customWait(4);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomPLUType);
			md.selectByIndex(wd, RBIPage.rbiOfferVendorConfigSicomPLUType,2);
			md.customWait(4);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String pluValue = dataSet.getField("SicomConstantPLUValue");
				upDateLog("Offer SicomConstantPLUValue to update " + pluValue);
				md.customWait(3);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomConstantPLUValue);
				WebElement elm = wd.findElement(RBIPage.rbiOfferVendorConfigSicomConstantPLUValue);
				elm.sendKeys(Keys.CONTROL + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferVendorConfigSicomConstantPLUValue, pluValue);
			}
			status = "Pass";
			con.close();
			String path = md.takeScreenShot(wd, "vendorConfigSicomPluTypeConstantAndValueEnter");
			report.addTestStep("Select and Update Sicom Constant PLU Value", "vendorConfigSicomPluTypeConstantAndValueEnter", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning vendorConfigSicomPluTypeConstantAndValueEnter method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "vendorConfigSicomPluTypeConstantAndValueEnter");
			report.addTestStep("Select and Update Sicom Constant PLU Value", "vendorConfigSicomPluTypeConstantAndValueEnter", status, path);
			return null;
		}finally {
			rbiContentVendorConfigSicomOpenClose(wd);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	public static WebDriver vendorConfigSicomDeliveryPluTypeConstantAndValueEnter(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			rbiContentVendorConfigOpenClose(wd);
			md.customWait(4);
			rbiContentVendorConfigSicomDeliveryOpenClose(wd);
			md.customWait(4);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryPLUType);
			md.click(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryPLUType);
			md.selectByIndex(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryPLUType,2);
			md.customWait(4);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String pluValue = dataSet.getField("SicomDeliveryConstantPLUValue");
				upDateLog("Offer SicomDeliveryConstantPLUValue to update " + pluValue);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryConstantPLUValue);
				WebElement elm = wd.findElement(RBIPage.rbiOfferVendorConfigSicomDeliveryConstantPLUValue);
				elm.sendKeys(Keys.CONTROL + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryConstantPLUValue, pluValue);
			}
			status = "Pass";
			con.close();
			String path = md.takeScreenShot(wd, "vendorConfigSicomDeliveryPluTypeConstantAndValueEnter");
			report.addTestStep("Select and Update Sicom Delivery Constant PLU Value", "vendorConfigSicomDeliveryPluTypeConstantAndValueEnter", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning vendorConfigSicomDeliveryPluTypeConstantAndValueEnter method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "vendorConfigSicomDeliveryPluTypeConstantAndValueEnter");
			report.addTestStep("Select and Update Sicom Delivery Constant PLU Value", "vendorConfigSicomPluTypeConstantAndValueEnter", status, path);
			return null;
		}finally {
			rbiContentVendorConfigSicomDeliveryOpenClose(wd);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	public static WebDriver vendorConfigNCR(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			rbiContentVendorConfigOpenClose(wd);
			md.customWait(4);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigNCR);
			md.click(wd, RBIPage.rbiOfferVendorConfigNCR);
			md.selectByIndex(wd, RBIPage.rbiOfferNCRSizeBasedPLU,7);
			md.customWait(4);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String pluValue = dataSet.getField("NCRPluValue");
				upDateLog("Offer vendorConfigNCR to update " + pluValue);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferNCRSizeBasedPLUInput);
				md.click(wd, RBIPage.rbiOfferNCRSizeBasedPLUInput);

				WebElement elm = wd.findElement(RBIPage.rbiOfferNCRSizeBasedCombo);
				elm.sendKeys(Keys.COMMAND + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferNCRSizeBasedCombo, pluValue);

				md.jsExecutorScrolll(wd, RBIPage.rbiOfferNCRComboSize);
				md.selectByIndex(wd, RBIPage.rbiOfferNCRComboSize,1);
			}
			status = "Pass";
			con.close();
			String path = md.takeScreenShot(wd, "vendorConfigNCR");
			report.addTestStep("Select and Update NCR Delivery SizeBased PLU", "vendorConfigNCR", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning vendorConfigNCR method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "vendorConfigNCR");
			report.addTestStep("Select and Update NCR Delivery SizeBased PLU", "vendorConfigNCR", status, path);
			return null;
		}finally {
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigNCR);
			md.click(wd, RBIPage.rbiOfferVendorConfigNCR);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	//Vendor Config Sicom Select Constant PLU and Enter PLU Value
	public static WebDriver vendorConfigSicom(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			rbiContentVendorConfigOpenClose(wd);
			md.customWait(4);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicom);
			md.click(wd, RBIPage.rbiOfferVendorConfigSicom);
			md.selectByIndex(wd, RBIPage.rbiOfferVendorConfigSicomPLUType,2);
			md.customWait(4);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String pluValue = dataSet.getField("SicomConstantPLUValue");
				upDateLog("Offer vendorConfigSicom to update " + pluValue);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomConstantPLUValue);
				md.click(wd, RBIPage.rbiOfferVendorConfigSicomConstantPLUValue);
				WebElement elm = wd.findElement(RBIPage.rbiOfferVendorConfigSicomConstantPLUValue);
				elm.sendKeys(Keys.COMMAND + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferVendorConfigSicomConstantPLUValue, pluValue);
			}
			status = "Pass";
			con.close();
			String path = md.takeScreenShot(wd, "vendorConfigSicom");
			report.addTestStep("Select ConstantPLU type for Sicom and enter PLU value", "vendorConfigSicom", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning vendorConfigSicom method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "vendorConfigSicom");
			report.addTestStep("Select ConstantPLU type for Sicom and enter PLU value", "vendorConfigSicom", status, path);
			return null;
		}finally {
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicom);
			md.click(wd, RBIPage.rbiOfferVendorConfigSicom);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	//Vendor Config Sicom Delivery Select Constant PLU and Enter PLU Value
	public static WebDriver vendorConfigSicomDelivery(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			rbiContentVendorConfigOpenClose(wd);
			md.customWait(4);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomDelivery);
			md.click(wd, RBIPage.rbiOfferVendorConfigSicomDelivery);
			md.selectByIndex(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryPLUType,2);
			md.customWait(4);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String pluValue = dataSet.getField("SicomDeliveryConstantPLUValue");
				upDateLog("Offer vendorConfigSicom to update " + pluValue);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryConstantPLUValue);
				md.click(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryConstantPLUValue);
				WebElement elm = wd.findElement(RBIPage.rbiOfferVendorConfigSicomDeliveryConstantPLUValue);
				elm.sendKeys(Keys.COMMAND + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferVendorConfigSicomDeliveryConstantPLUValue, pluValue);
			}
			status = "Pass";
			con.close();
			String path = md.takeScreenShot(wd, "vendorConfigSicomDelivery");
			report.addTestStep("Select ConstantPLU type for Sicom Delivery and enter PLU value", "vendorConfigSicomDelivery", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning vendorConfigSicom method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "vendorConfigSicomDelivery");
			report.addTestStep("Select ConstantPLU type for Sicom Delivery and enter PLU value", "vendorConfigSicomDelivery", status, path);
			return null;
		}finally {
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigSicomDelivery);
			md.click(wd, RBIPage.rbiOfferVendorConfigSicomDelivery);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	//This is to select Vendor Config for NCR Delivery
	public static WebDriver vendorConfigNCRDelivery(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			rbiContentVendorConfigOpenClose(wd);
			md.customWait(4);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigNCRDelivery);
			md.click(wd, RBIPage.rbiOfferVendorConfigNCRDelivery);
			md.selectByIndex(wd, RBIPage.rbiOfferNCRSizeBasedPLUDelivery,7);
			md.customWait(4);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String pluValue = dataSet.getField("NCRDeliveryPluValue");
				upDateLog("Offer vendorConfigSicom to update " + pluValue);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferNCRSizeBasedPLUInputDelivery);
				md.click(wd, RBIPage.rbiOfferNCRSizeBasedPLUInputDelivery);
				WebElement elm = wd.findElement(RBIPage.rbiOfferNCRSizeBasedComboDelivery);
				elm.sendKeys(Keys.COMMAND + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferNCRSizeBasedComboDelivery, pluValue);
				md.selectByIndex(wd, RBIPage.rbiOfferNCRComboSizeDelivery, 1);
			}
			status = "Pass";
			con.close();
			String path = md.takeScreenShot(wd, "vendorConfigNCRDelivery");
			report.addTestStep("Select SizebasedPLU type for NCR Delivery and enter PLU value with Size as small", "vendorConfigNCRDelivery", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning vendorConfigNCRDelivery method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "vendorConfigNCRDelivery");
			report.addTestStep("Select SizebasedPLU type for NCR Delivery and enter PLU value with Size as small", "vendorConfigNCRDelivery", status, path);
			return null;
		}finally {
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigNCRDelivery);
			md.click(wd, RBIPage.rbiOfferVendorConfigNCRDelivery);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	public static WebDriver vendorConfigCarrols(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			rbiContentVendorConfigOpenClose(wd);
			md.customWait(4);
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigCarrols);
			md.click(wd, RBIPage.rbiOfferVendorConfigCarrols);
			md.selectByIndex(wd, RBIPage.rbiOfferVendorConfigCarrolsConstantPlu,2);
			md.customWait(4);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String pluValue = dataSet.getField("CarrolsPLUValue");
				upDateLog("Offer vendorConfigCarrols to update " + pluValue);
				md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigCarrolsPluValue);
				WebElement elm = wd.findElement(RBIPage.rbiOfferVendorConfigCarrolsPluValue);
				elm.sendKeys(Keys.COMMAND + "a");
				elm.sendKeys(Keys.DELETE);
				md.enterData(wd, RBIPage.rbiOfferVendorConfigCarrolsPluValue, pluValue);
			}
			status = "Pass";
			con.close();
			String path = md.takeScreenShot(wd, "vendorConfigCarrols");
			report.addTestStep("Select ConstantPLU type for Carrols and enter PLU value", "vendorConfigCarrols", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning vendorConfigCarrols method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "vendorConfigCarrols");
			report.addTestStep("Select ConstantPLU type for Carrols and enter PLU value", "vendorConfigCarrols", status, path);
			return null;
		}finally {
			md.jsExecutorScrolll(wd, RBIPage.rbiOfferVendorConfigCarrols);
			md.click(wd, RBIPage.rbiOfferVendorConfigCarrols);
			rbiContentVendorConfigOpenClose(wd);
		}
	}
	public static WebDriver ruleSetDelete(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.jsExecutorScrolll(wd, RBIPage.ruleSet);
			List<WebElement> ele = wd.findElements(RBIPage.ruleSetDelete);
			if(ele.size()>1){
				ele.stream().forEach(element ->{element.submit();});
				md.click(wd, RBIPage.ruleSetRemoveItem);
			}
			md.click(wd, RBIPage.ruleSetDelete);
			md.click(wd, RBIPage.ruleSetRemoveItem);
			String path = md.takeScreenShot(wd, "ruleSetDelete");
			status = "Pass";
			report.addTestStep("Rule Set Delete All Existing Rule-Set", "ruleSetDelete", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning ruleSetDelete method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "ruleSetDelete");
			report.addTestStep("Rule Set Delete All Existing Rule-Set", "ruleSetDelete", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver ruleSet_Add_And_Limit(WebDriver wd, String id){
		Connection con = null;
		try{
			md = getReUsableMethods(wd);
			md.jsExecutorScrolll(wd, RBIPage.ruleSetAdd);
			md.click(wd, RBIPage.ruleSetAdd);
			md.click(wd, RBIPage.ruleSetAnd);
			md.click(wd, RBIPage.ruleSetAndAddItem);
			md.click(wd, RBIPage.ruleSetAndLimit);
			con = ExcelData.getExcelConnection();
			String key = testData.getTestData(id);
			Recordset dataSet = con.executeQuery("Select * from Data").where("ID = "+ "'" + id + "'");
			while (dataSet.next()){
				String andLimit = dataSet.getField("AndLimit");
				String AndInterval = dataSet.getField("AndInterval");
				upDateLog("Rule Set And Limit Set To " + andLimit);
				upDateLog("Rule Set And Interval Set To " + AndInterval);
				md.enterData(wd, RBIPage.ruleSetAndLimitMaximumRedemptions, andLimit);
				md.selectByText(wd, RBIPage.ruleSetAndLimitMaximumRedemptionsInterval, AndInterval);
			}
			md.click(wd, RBIPage.ruleSetAndLimitMaximumRedemptionsClose);
			md.click(wd, RBIPage.ruleSetAndClose);
			md.customWait(10);
			String path = md.takeScreenShot(wd, "ruleSet_Add_And_Limit");
			status = "Pass";
			report.addTestStep("Rule Set And Limit Set", "ruleSet_Add_And_Limit", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning ruleSet_Add_And_Limit method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "ruleSet_Add_And_Limit");
			report.addTestStep("Rule Set And Limit Set", "ruleSet_Add_And_Limit", status, path);
			return null;
		}finally {
			status = null;
		}
	}
	public static WebDriver option_Select_First(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.jsExecutorScrolll(wd, RBIPage.option);
			md.click(wd, RBIPage.option_Expand);
			md.click(wd, RBIPage.option_SelectFirst);
			String path = md.takeScreenShot(wd, "option_Select_First");
			status = "Pass";
			report.addTestStep("Selecting Option", "option_Select_First", status, path);
			return wd;
		}catch (Exception ex){
			upDateLog("Exception while returning option_Select_First method." + "\n" + ex.toString());
			status = "Fail";
			String path = md.takeScreenShot(wd, "option_Select_First");
			report.addTestStep("Selecting Option", "option_Select_First", status, path);
			return null;
		}finally {
			status = null;
		}
	}

	public static WebDriver bww_login(WebDriver wd){
		try{
			md = getReUsableMethods(wd);
			md.getURL(wd, getFromProperties("BWWURL"));

			String path = md.takeScreenShot(wd, "BWW_Login");
			status = "Pass";
			report.addTestStep("BWW Login", "Open Chrome and Navigate to BWW login Page", status, path);
			return wd;

		}catch (Exception ex){
			upDateLog("Exception in BWW Login Page " + "\n" + ex.toString());
			String path = md.takeScreenShot(wd, "BWW_Login");
			status = "Fail";
			report.addTestStep("BWW Login", "Open Chrome and Navigate to BWW login Page", status, path);
			return null;

		}finally {
			status = null;
		}
	}
}