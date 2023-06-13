package com.main.framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.framework.api.GmailApiUtil;
import com.google.common.base.Verify;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.framework.Report;

import Enums.DriverOptions;
import configReader.PropertyFileReader;
import driver.DriverSupplier;
import element.Elements;
import excel.ExcelReader;

public class PageObjects extends Elements {

	WebDriver driver=null;
	WebDriverWait wait =null;
	PropertyFileReader propReader;

	ExtentReports reports= null;
	ExtentTest test = null;
	int i;
	Report rep=null;


	public PageObjects(ExtentReports reports,Report rep){
		this.reports = reports;
		this.rep = rep;
	}

	public PageObjects setupSuite(){
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		propReader = new PropertyFileReader();
		i = Integer.parseInt(propReader.getConfigval("waittime"));
		String drvselected = propReader.getConfigval("DriverName").toLowerCase();
		if(drvselected.equals(DriverOptions.chrome.toString())){
			driver = DriverSupplier.getChromeDriver();
			wait = new WebDriverWait(driver,30);
		}else if(drvselected.equals(DriverOptions.firefox.toString())){
			driver = DriverSupplier.getGechoDriver();
			wait = new WebDriverWait(driver,30);
		}else{
			driver = DriverSupplier.getChromeDriver();
			wait = new WebDriverWait(driver,30);
		}

		return this;

	}

	public PageObjects launchUrl(Boolean status){
		
		if(status){
		test = reports.startTest("TC_001 : Validate user "+propReader.getConfigval("email")+" is able to Login");
		rep.addTest("TC_001 : Validate user '"+propReader.getConfigval("email")+"' is able to Login");
		}
		String emailId = propReader.getConfigval("email");
		driver.get(propReader.getConfigval("url"));
		driver.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);
		Verify.verify(driver.getCurrentUrl().equalsIgnoreCase(propReader.getConfigval("url")));
		if(status){
			addStep("Navigated to specified url",true);
		}
		return this;
	}

	public PageObjects enterAppPassword(){
		//entering app password
		try {
			sendKeysP(driver.findElement(passwordTextBox),"rbi-tech");
			addStep("Entering password",true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}

		//clicking submit button
		try {
			clickP(driver.findElement(submitBtn));
			addStep("Clicking on submit button",true);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			addStep("Clicking on submit button",false);
			e1.printStackTrace();
		}
		return this;
	}

	public PageObjects selectLanguageUSEn(){

		//"Selecting Language"
		
		try {
			clickP(driver.findElement(radioUsEn));
			test.log(LogStatus.PASS, "Selecting Language");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			test.log(LogStatus.FAIL, "Selecting Language");
			e1.printStackTrace();
			throw e1;
		}
		//clicking apply button
		
		try {
			clickP(driver.findElement(applyBtn));
			test.log(LogStatus.PASS, "Clicking on Apply button");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			test.log(LogStatus.FAIL, "Clicking on Apply button");
			e1.printStackTrace();
		}
		return this;
	}
	
	

	public PageObjects clickLoginLink(){

		//clicking login button
		try {
			clickP(driver.findElement(loginBtn));
			wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBox));
			addStep("Clicking on Login button",true);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			try {
				clickP(driver.findElement(loginBtn));
				addStep("Clicking on Login button",true);
			} catch (Exception e) {
				addStep("Clicking on Login button",false);
				e.printStackTrace();
				throw e;
			}
		}
		return this;
	}

	public PageObjects enterEmail(){

		String emailId = propReader.getConfigval("email");
		//entering email id
		try {

			sendKeysP(driver.findElement(emailTextBox),emailId);
			addStep("Enter email "+emailId,true);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			addStep("Enter email "+emailId,false);
			e1.printStackTrace();
			throw e1;
		}
		return this;
	}


	public PageObjects clickSignIn(){
		//clicking Sign in button
		try {
			clickP(driver.findElement(signInBtn));
			
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(verifyText)));
			addStep("Clicking on Login button",true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			addStep("Clicking on Login button",false);
			e1.printStackTrace();
			throw e1;
		}
		return this;
	}
	
	public PageObjects clickApplyBtn(){
		//clicking apply button
		
				try {
					clickP(driver.findElement(applyBtn));
					addStep("Clicking on Apply button",true);
					driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					addStep("Clicking on apply button",false);
					e1.printStackTrace();
				}
				return this;
	}

	public PageObjects enterOtp(){
		try {
			//Call OTP fetch
			delay(10);
			String accessToken = GmailApiUtil.generateAccessToken(propReader.getConfigval("email"));
			String id = GmailApiUtil.findAllEmailId(accessToken);
			String Otp = GmailApiUtil.findLastReceivedEmailBody(accessToken, id).substring(140, 146);

			//entering Otp
			sendKeysP(driver.findElement(OtpTextBox),Otp);
			addStep("Enter Otp",true);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			addStep("Enter Otp",false);
			e1.printStackTrace();
		}
		return this;
	}

	public PageObjects validateLogin(){
		//verify login
		try {
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(accountLink)));
			addStep("User Logged in",true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			addStep("User Logged in",false);
			e1.printStackTrace();
			throw e1;
		}
		return this;
	}

	public PageObjects clickLocationLink(){
		test = reports.startTest("Validate user is able to select Location");
		rep.addTest("TC_002 : Validate user is able to select Location");
		addStep("TC_002 : Login with valid credentials",true);
		try {
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(locationLink).click();	
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(verifyLocText)));
			addStep("Clicking on location link",true);
		} catch (StaleElementReferenceException e1) {
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.navigate().refresh();
			driver.findElement(locationLink).click();	
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(verifyLocText)));
			addStep("Clicking on location link",true);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			addStep("Clicking on location link",false);
			System.out.println("loc link failed");
			e2.printStackTrace();
		}
		return this;
	}

	public PageObjects clickFavAddsLink(){
		try {
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(favouritesLink)));
			driver.findElement(favouritesLink).click();	
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			addStep("Clicking on favourites link",true);
		} catch (Exception e2) {
			try {
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(favouritesLink)));				
				driver.findElement(favouritesLink).click();	
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				addStep("Clicking on favourites link",true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				addStep("Clicking on favourites link",false);
				e.printStackTrace();
			}
		}return this;
	}

	public PageObjects clickLocation(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locationsList)));
			String s = driver.findElement(locationsList).getText();
			driver.findElement(locationsList).click();
			addStep("Clicked location",true);
		}catch(Exception e){
			try {
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locationsList)));
				String s = driver.findElement(locationsList).getText();
				driver.findElement(locationsList).click();
				addStep("Clicked location",true);
			} catch (Exception e1) {
				e1.printStackTrace();
				addStep("Clicked location",false);
			}

		}return this;
	}

	public PageObjects clickOrderBtn(){
		try{
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(orderBtn)));
			driver.findElement(orderBtn).click();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			addStep("Clicked Order button",true);
			test.log(LogStatus.PASS, "Clicked Order button");
		}catch(Exception e){
			addStep("Clicked Order button",false);
		}
		return this;
	}

	public PageObjects loadMenu(){

		driver.get(propReader.getConfigval("url")+"menu/");

		return this;
	}

	String itemname;
	int counter = 1;
	
	public PageObjects clickCategory(String category,String itemname){
		this.itemname = itemname;
		test = reports.startTest("Validate item "+ counter +" "+itemname);
		rep.addTest("Validate item "+ counter +" "+itemname);
		try {
			delay(3);
			clickJS(driver.findElement(By.xpath(getCategoryXpath(category))));} catch (Exception e) {}

		try {
			/*wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(.,'"+category+"')]"))));*/	
			/*wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(.,'"+category+"')]"))));*/
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("tileth__ItemName-qvp911-6"))));
			addStep("Clicked Category "+category,true);
		} catch (Exception ex) {
			addStep("Clicked Category "+category,false);
			ex.printStackTrace();
		}
		counter++;
		return this;
	}
	public PageObjects clickSubCategory(String subcategory){
		
		
		if(subcategory==null||subcategory.equals("")||subcategory.isEmpty()){
			return this;
		}else{
			try {
				delay(3);
				clickJS(driver.findElement(By.xpath(getCategoryXpath(subcategory))));
				test.log(LogStatus.PASS, "Clicked Sub Category "+subcategory);
			} catch (Exception ex) {
				//test.log(LogStatus.FAIL, "Clicked Sub Category "+subcategory,ex.getLocalizedMessage());
				ex.printStackTrace();
			}
		}

		return this;
	}

	public PageObjects clickItem(){
		try {
			delay(3);
			clickJS(driver.findElement(By.xpath(getItemXpath(this.itemname))));} catch (Exception e) {}

		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(.,'"+itemname+"')]"))));
			addStep("Clicked item "+itemname,true);
		} catch (Exception ex) {
			addStep("Clicked item "+itemname,false);
			ex.printStackTrace();
		}
		return this;
	}

	public PageObjects checkSizes(){
		boolean sizesPresent=false;
		try {
			wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.elementToBeClickable(sizesAccordion)).click();
			wait = new WebDriverWait(driver,i);
			test.log(LogStatus.INFO, "This item has different sizes");
			sizesPresent= true;
		} catch (Exception e) {}

		if(sizesPresent){
			int sizeCount = driver.findElements(sizeOptions).size();
			System.out.println("size count "+sizeCount);
			for(int c=0;c<=sizeCount ; c++){
				try{
					delay(5);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					clickJS(driver.findElements(sizeOptions).get(c));
					delay(1);
					String s= driver.findElement(addToCartBtn).getText().trim();
					s= s.replaceAll("[^0-9|\\.]", "");
					test.log(LogStatus.INFO, "Price of size #"+c+" :$"+s);
				}catch(Exception e){
					System.out.println("failed at "+c+" "+e.getMessage());
				}
			}
		}else{
			String s= driver.findElement(addToCartBtn).getText().trim();
			s= s.replaceAll("[^0-9|\\.]", "");
			test.log(LogStatus.INFO, "Price :$"+s);
		}

		return this;
	}

	public PageObjects selectSize(int siz){
		boolean sizesPresent=false;
		try {
			wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.elementToBeClickable(sizesAccordion)).click();
			wait = new WebDriverWait(driver,i);
			test.log(LogStatus.INFO, "This item has different sizes");
			sizesPresent= true;
		} catch (Exception e) {}

		if(sizesPresent){
			try{

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				clickJS(driver.findElements(sizeOptions).get(siz));
				delay(1);
				String s= driver.findElement(addToCartBtn).getText().trim();
				s= s.replaceAll("[^0-9|\\.]", "");
				test.log(LogStatus.INFO, "Price of size #"+(siz+1)+" :$"+s);
			}catch(Exception e){

			}
		}else{
			return this;

		}

		return this;
	}

	public PageObjects validatePrice(String price){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(addToCartBtn)));
		String s= driver.findElement(addToCartBtn).getText().trim();
		s= s.replaceAll("[^0-9|\\.]", "");

		String page = driver.getTitle();
		if(price.equals(s)){
			addStep(page +": Expected Price :$"+price+" Actual Price :$"+s,true);
		}else{
			addStep(page +": Expected Price :$"+price+" Actual Price :$"+s,false);
		}


		return this;
	}

	public PageObjects addItemToCart(){
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(addToCartBtn)));
			moveToElementJS(driver.findElement(addToCartBtn));
			delay(1);
			clickJS(driver.findElement(addToCartBtn));} catch (Exception e) {}

		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(verifyMenuText)));
			addStep( "Added item to cart",true);
			test.log(LogStatus.PASS, "Added item to cart");
		}catch(Exception e){
			addStep( "Added item to cart",false);
		}
		return this;
	}

	public void moveByJS(int x,int y){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}

	public PageObjects clickCartIcon(){
		try{
			clickP(driver.findElement(cartIcon));}catch(Exception e){}

		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(checkoutBtn)));
			addStep( "Clicked cart icon",true);
		}catch(Exception e){
			addStep( "Clicked cart icon",false);
		}return this;
	}



	public PageObjects clickCheckoutBtn(){
		try{
			clickP(driver.findElement(checkoutBtn));}catch(Exception e){}

		try{
			wait.until(ExpectedConditions.urlContains("cart"));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(continueBtn)));
			addStep("Clicked checkout button",true);
		}catch(Exception e){
			//test.log(LogStatus.FAIL, "Clicked checkout Button");
		}return this;
	}

	public PageObjects getCartPagePrice(String price){

		try{
			wait.until(ExpectedConditions.urlContains("cart"));
			String cartP = wait.until(ExpectedConditions.visibilityOf(driver.findElement(subTotalPrice))).getText().replace("$", "");
			String page = driver.getTitle();
			
			if(price.equals(cartP)){
				addStep(page +": Expected Price :$"+price+" Actual Price :$"+cartP,true);
			}else{
				addStep(page +": Expected Price :$"+price+" Actual Price :$"+cartP,false);
			}
		}catch(Exception e){
		}return this;
	}

	public PageObjects clickContinueBtn(){
		try{
			delay(5);
			clickP(driver.findElement(continueBtn));
		}catch(Exception e){
			System.out.println("problem *************************************");
			System.out.println("problem *************************************");
			e.printStackTrace();
			System.out.println("problem *************************************");
			System.out.println("problem *************************************");
		}

		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(placeOrderBtn)));
		}catch(Exception e){
			try {
				delay(5);
				clickJS(driver.findElement(continueBtn));
			} catch (Exception e1) {
			}
		}

		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(placeOrderBtn)));
			addStep("Clicked continue Button",true);
		}catch(Exception e){
			addStep("Clicked continue Button",false);
		}
		return this;
	}

	public PageObjects clickPlaceSecureOrderbtn(){
		try{
			clickJS(driver.findElement(placeOrderBtn));}catch(Exception e){
				e.printStackTrace();
			}
		try{
			wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(placeDuplicateOrder))).click();
			wait = new WebDriverWait(driver,i);
		}catch(Exception e){

		}

		try{
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(homeBtn)));
			String oNO = wait.until(ExpectedConditions.visibilityOf(driver.findElement(orderNo))).getText().replaceAll("[^0-9]", "");
			addStep( "Order Placed! ("+oNO+")",true);
		}catch(Exception e){
			addStep( "Problem fetching the order number",false);
		}

		try{
			clickP(driver.findElement(storeCloseOkBtn));
		}catch(Exception e){

		}

		return this;
	}

	public PageObjects getOrderSummaryPrice(String price){
		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(orderConfirmationPrice)));
			String oNO = wait.until(ExpectedConditions.visibilityOf(driver.findElement(orderConfirmationPrice))).getText().replaceAll("[^0-9|\\.]", "");
			String page = driver.getTitle();
			
			if(price.equals(oNO)){
				addStep(page +": Expected Price :$"+price+" Actual Price :$"+oNO,true);
			}else{
				addStep(page +": Expected Price :$"+price+" Actual Price :$"+oNO,false);
			}
		}catch(Exception e){
			e.printStackTrace();	
		}
		return this;
	}

	public PageObjects clickHomeButton(){
		try{
			clickP(driver.findElement(homeBtn));}catch(Exception e){		
			}

		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(ordrHeaderBtn)));
			addStep( "Clicked Home Button",true);
			
		}catch(Exception e){
			addStep( "Clicked Home Button",false);
		}return this;
	}
	public PageObjects verifyLanguage(String expected){
		try{
		
			String languageActual = driver.findElement(languageFooter).getText();
			
			if(expected.equalsIgnoreCase(languageActual)){
				test.log(LogStatus.PASS, "Correct language is selected");
			}else{
				test.log(LogStatus.FAIL, "Correct language is selected");

			}
		}
		catch(Exception e){		
			}
		
		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(ordrHeaderBtn)));
			test.log(LogStatus.PASS, "Clicked Home Button");
		}catch(Exception e){
			test.log(LogStatus.FAIL, "Clicked Home Button");
		}return this;
	}

	public PageObjects clickHeaderOrderButton(){
		try{
			clickP(driver.findElement(ordrHeaderBtn));}catch(Exception e){	
				clickP(driver.findElement(ordrHeaderBtn));
			}

		return this;
	}
	
	
	public PageObjects clickLocationFooter(){
		try{
			clickJSnoWait(driver.findElement(locationLinkFooter));}catch(Exception e){	
				delay(3);
				clickJSnoWait(driver.findElement(locationLinkFooter));
			}
		
		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(favouritesLink)));
			addStep("Clicked Location link from Footer",true);
		}catch(Exception e){
			addStep("Clicked Location link from Footer",false);
		}return this;
	}

	public PageObjects tearDown(){
		driver.quit();
		reports.endTest(test);
		reports.flush();
		rep.closeReport();
		return this;
	}

	public PageObjects moveToElementJS(WebElement e){

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", e);

		return this;
	}


	public void sendKeysP(WebElement e,String s){

		try{
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(e));
			e.sendKeys(s);
		}catch(Exception e1){
			e1.printStackTrace();
		}

	}

	public void sendKeysP(WebElement e,Keys k){

		try{
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			delay(1);
			wait.until(ExpectedConditions.elementToBeClickable(e));
			e.sendKeys(k);
		}catch(Exception e1){
			e1.printStackTrace();
		}

	}

	public void clickP(WebElement e){

		try{
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(e));
			e.click();
		}catch(Exception e1){
			e1.printStackTrace();
		}

	}
	public void clickJS(WebElement e){
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(e));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",e);
		e.click();

	}
	
	public void clickJSnoWait(WebElement e){
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		delay(3);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",e);
		e.click();

	}

	static void delay(double d){
		try {
			Thread.sleep((long) (d*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void takeSnapShot(String fileWithPath) throws Exception{

		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);

	}

	public String takess(String fpath) {

		TakesScreenshot tss = ((TakesScreenshot)driver);
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File(fpath);

		try {
			FileUtils.copyFile(src, dst);
			return dst.getAbsolutePath();
		} catch (IOException e) {
			return null;
		}
	}
	/*
	public String getCategoryXpath(String categoryName){
		return "//div[@class='tileth__ListTileDescription-qvp911-5 gVQtKM'][contains(.,'"+categoryName+"')]";
	}
	*/
	public String getCategoryXpath(String categoryName){
		//return "//span[contains(text(),'"+categoryName+"')]";
		return "//span[normalize-space()='Cold Beverages']";
	}

	public String getSubCategoryXpath(String categoryName){
		//return "//div[@class='tileth__ListTileDescription-qvp911-5 gVQtKM'][contains(.,'"+categoryName+"')]";
		return "//span[normalize-space()='Peach Real Fruit Quencher']";
	}

	public String getItemXpath(String itemName){
		return "//span[contains(.,'"+itemName+"')]";
	}
	
	void addStep(String stepname,Boolean status){
		if(status){
			test.log(LogStatus.PASS, stepname);
			rep.addTestStep(stepname, stepname, "Pass", "");

		}else{
			Random r = new Random(9999);
			String spath = takess(".\\SS\\screen"+r.nextInt()+".png");
			test.log(LogStatus.FAIL, stepname);
			test.log(LogStatus.FAIL, test.addScreenCapture(spath));
			rep.addTestStep(stepname, stepname, "Fail", spath);
		}
			}


}
