package com.testcases.framework;

import java.awt.Rectangle;
import java.io.File;

import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import cognizant.framework.pageobject.BeverageItems;
import cognizant.framework.pageobject.BreakfastItems;
import cognizant.framework.pageobject.ExtentReporterNG;
import cognizant.framework.pageobject.LandingPage;
import cognizant.framework.pageobject.LunchItems;

import cognizant.framework.pageobject.SideItems;
import cognizant.framework.pageobject.appClose;
import excel.Read_Data;
import net.sourceforge.tess4j.TesseractException;

public class Runner extends Read_Data  {
	
	
Screen s = new Screen();

ExtentReports extent;
ExtentSparkReporter html;
ExtentTest testcase;


public int i;
public int parseInt;
public int number;
public WebDriver wd;

  @Test
  public void appLogin() throws FindFailed, IOException, TesseractException, InterruptedException {
	  
	  
	  extent=new ExtentReports();
	    html= new ExtentSparkReporter("extent.html");
	    extent.attachReporter(html);
		
		
	LandingPage landingPage =new LandingPage(s);
	landingPage.siKuliTestCase001(extent, testcase);
	
	/*BreakfastItems breakfastsitem = new BreakfastItems(s);
	breakfastsitem.siKuliTestCase002(extent, testcase);
	breakfastsitem.siKuliTestCase003(extent, testcase);*/
	BeverageItems bevItem =new BeverageItems(s);
	//bevItem.siKuliTestCase004(extent, testcase);
	bevItem.siKuliTestCase005(extent, testcase);
	//bevItem.siKuliTestCase006(extent, testcase);
	bevItem.siKuliTestCase007(extent, testcase);
	//bevItem.siKuliTestCase008(extent, testcase);
	bevItem.siKuliTestCase009(extent, testcase);
	//bevItem.siKuliTestCase010(extent, testcase);
	/*bevItem.siKuliTestCase011(extent, testcase);
	bevItem.siKuliTestCase012(extent, testcase);
	bevItem.siKuliTestCase013(extent, testcase);
	bevItem.siKuliTestCase014(extent, testcase);
	bevItem.siKuliTestCase015(extent, testcase);
	bevItem.sikuliTestCase016(extent, testcase);
	bevItem.sikuliTestCase017(extent, testcase);
	bevItem.sikuliTestCase018(extent, testcase);
	bevItem.sikuliTestCase019(extent, testcase);
	bevItem.sikuliTestCase020(extent, testcase);
	bevItem.sikuliTestCase021(extent, testcase);
	bevItem.sikuliTestCase022(extent, testcase);
	//bevItem.sikuliTestCase023(extent, testcase);
	SideItems sideitems =new SideItems(s);
	/*sideitems.siKuliTestCase024(extent, testcase);
	sideitems.siKuliTestCase025(extent, testcase);
	sideitems.siKuliTestCase026(extent, testcase);
	sideitems.siKuliTestCase027(extent, testcase);
	sideitems.siKuliTestCase028(extent, testcase);*/
	/*LunchItems lunch =new LunchItems(s);
	lunch.sikuliTestCase029(extent,testcase);*/
	appClose apc =new appClose(s);
	apc.appClose(extent,testcase);

  }

  @AfterMethod(alwaysRun=true)
  public void getScreenshot(String testCaseName,Screen s,ExtentReports extent, ExtentTest testcase) throws IOException
  {
	 System.out.println("onTestFailure");
	  Rectangle rectangle=new Rectangle();
	  rectangle.setBounds(420,200,60,30);
	  String imagePath  = capture(rectangle).save("extent.html");
	
  }
}




