package cognizant.framework.pageobject;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import excel.Read_Data;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LunchItems extends Read_Data {
	
	ExtentReports extent;
	ExtentSparkReporter html;
	ExtentTest testcase;
	
	Pattern Lunch = new Pattern("C:\\Images For Sikuli\\Lunch.png");
  	Pattern Sandwiches1 = new Pattern("C:\\Images For Sikuli\\Sandwiches1.png");
  	Pattern TurkeyBaconClub = new Pattern("C:\\Images For Sikuli\\TurkeyBaconClub.png");
  	
  	Pattern Melt = new Pattern("C:\\Images For Sikuli\\Melt.png");
  	Pattern HamMelt = new Pattern("C:\\Images For Sikuli\\HamMelt.png");
  	
  	Pattern LoadedWraps = new Pattern("C:\\Images For Sikuli\\LoadedWraps.png");
  	Pattern CilantroWrap = new Pattern("C:\\Images For Sikuli\\CilantroWrap.png");
  	Pattern CrispyWrap = new Pattern("C:\\Images For Sikuli\\CrispyWrap.png");
  	Pattern FarmerSandwiches = new Pattern("C:\\Images For Sikuli\\FarmerSandwiches.png");
  	Pattern Belts = new Pattern("C:\\Images For Sikuli\\Belts.png");
  	Pattern BaconBelt = new Pattern("C:\\Images For Sikuli\\BaconBelt.png");
  	Pattern PlainBagel = new Pattern("C:\\Images For Sikuli\\PlainBagel.png");
  	Pattern ChooseBagel = new Pattern("C:\\Images For Sikuli\\ChooseBagel.png");
  	Pattern BlueberyBagel = new Pattern("C:\\Images For Sikuli\\BlueberyBagel.png");
  	Pattern HotBowls = new Pattern("C:\\Images For Sikuli\\HotBowls.png");
  	Pattern ChickenNoodle = new Pattern("C:\\Images For Sikuli\\ChickenNoodle.png");
  	Pattern BiscuitModifier = new Pattern("C:\\Images For Sikuli\\BiscuitModifier.png");
  	Pattern SausageModifier = new Pattern("C:\\Images For Sikuli\\SausageModifier.png");
  	Pattern SausageModifier1 = new Pattern("C:\\Images For Sikuli\\SausageModifier1.png");
  	
  	Pattern Bagels = new Pattern("C:\\Images For Sikuli\\Bagels.png");
  	Pattern GrainBagelPrePared = new Pattern("C:\\Images For Sikuli\\GrainBagelPrePared.png");
  	
  
  	Pattern Breakfast = new Pattern("C:/Images For Sikuli/Breakfast.png"); 
  	Pattern Sandwiches = new Pattern("C:/Images For Sikuli/Sandwiches.png"); 
  	Pattern SausageBiscuit = new Pattern("C:/Images For Sikuli/SausageBiscuit.png"); 
  	Pattern Functions = new Pattern("C:/Images For Sikuli/Functions.png"); 
  	Pattern MinPOS = new Pattern("C:/Images For Sikuli/MinPOS.png"); 
  	Pattern EatIn = new Pattern("C:/Images For Sikuli/EatIn.png"); 
  	Pattern VoidItem = new Pattern("C:\\Images For Sikuli\\VoidItem.png");
  	
    Screen s;
	private String readTurkeyBaconClubPrice;
	public LunchItems(Screen s) {
		// TODO Auto-generated constructor stub
		this.s =s;
		
	}
	
	@Test(priority = 29)
	public void sikuliTestCase029(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException
	{
		
		
		testcase=extent.createTest("TC_029:Verify BaconBeltPrice");
	    
		LunchItems b = new LunchItems(s);
		
		 Thread.sleep(2000); 
		s.wait(Lunch, 300);
 		s.click(Lunch.similar((float)0.5));
 		
 		 Thread.sleep(2000); 
 		s.wait(Sandwiches1, 300);
 		s.click(Sandwiches1.similar((float)0.5));
 		
 		 Thread.sleep(2000); 
 		s.wait(TurkeyBaconClub, 300);
 		s.click(TurkeyBaconClub.similar((float)0.5));
 		testcase.log(Status.PASS, "User able to click on TurkeyBaconClub");
 		s.wait(EatIn, 300);  
        s.click(EatIn.similar((float)0.8));
        testcase.log(Status.PASS, "User able to click on EatIn");
        Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "TurkeyBaconClub");
		  ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readSausageBiscuitPrice());
	      String a1=null;
	      String a2=null;
	      
	       String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readTurkeyBaconClubPrice;
  	   System.out.println(a1);
  	   System.out.println(a2);
	     
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of TurkeyBaconClubPrice" );
	    	  System.out.println("***********Scenario02 PASS: Correct ala carte price of TurkeyBaconClubPrice ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of TurkeyBaconClubPrice" );
	    	  System.out.println("***********Scenario02 FAIL: Incorrect ala carte price of TurkeyBaconClubPrice ***********");
	    	  
	     // soft.assertEquals(imageText, b.readTurkeyBaconClubPrice());
	      
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	      
	}
	}
}
