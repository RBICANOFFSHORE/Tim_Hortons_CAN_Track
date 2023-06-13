package cognizant.framework.pageobject;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import excel.Read_Data;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class BeverageItems extends Read_Data{
	
	ExtentReports extent;
	ExtentSparkReporter html;
	ExtentTest testcase;
	
	Pattern Beverages= new Pattern("C:\\Images For Sikuli\\Beverages.png");
  	Pattern OriginalBlend = new Pattern("C:\\Images For Sikuli\\OriginalBlend.png");
  	Pattern RefillSmallOriginalBlend= new Pattern("C:\\Images For Sikuli\\RefillSmallOriginalBlend.png");
  	Pattern RefillMediumOriginalBlend=new Pattern("C:\\Images For Sikuli\\RefillMediumOriginalBlend.png");
  	Pattern RefillLargeOriginalBlend=new Pattern("C:\\Images For Sikuli\\RefillLargeOriginalBlend.png");
  	Pattern RefillExtraLargeOriginalBlend=new Pattern("C:\\Images For Sikuli\\RefillExtraLargeOriginalBlend.png");
  	Pattern DarkRoast=new Pattern("C:\\Images For Sikuli\\DarkRoast.png");
  	Pattern SmallDarkRoast=new Pattern("C:\\Images For Sikuli\\SmallDarkRoast.png");
  	Pattern MediumDarkRoast=new Pattern("C:\\Images For Sikuli\\MediumDarkRoast.png");
  	Pattern LargeDarkRoast=new Pattern("C:\\Images For Sikuli\\LargeDarkRoast.png");
  	Pattern ExtraLargeDarkRoast=new Pattern("C:\\Images For Sikuli\\ExtraLargeDarkRoast.png");
  	Pattern SmallRefillDarkRoast=new Pattern("C:\\Images For Sikuli\\SmallRefillDarkRoast.png");
  	Pattern MediumRefillDarkRoast=new Pattern("C:\\Images For Sikuli\\MediumRefillDarkRoast.png");
  	Pattern LargeRefillDarkRoast=new Pattern("C:\\Images For Sikuli\\LargeRefillDarkRoast.png");
  	Pattern ExtraLargeRefillDarkRoast=new Pattern("C:\\Images For Sikuli\\ExtraLargeRefillDarkRoast.png");
  	Pattern Decaf = new Pattern("C:\\Images For Sikuli\\Decaf.png");
  	Pattern SmallSpecialtyTea =new Pattern("C:\\Images For Sikuli\\SmallSpecialtyTea.png");
  	Pattern MediumSpecialtyTea =new Pattern("C:\\Images For Sikuli\\MediumSpecialtyTea.png");
  	
  	Pattern SteepedTea = new Pattern("C:\\Images For Sikuli\\SteepedTea.png");
	Pattern SteepedTeaSmall = new Pattern("C:\\\\Images For Sikuli\\\\SteepedTeaSmall.png");
	Pattern SteepedTeaMedium = new Pattern("C:\\\\Images For Sikuli\\\\SteepedTeaMedium.png");
	Pattern SteepedTeaLarge = new Pattern("C:\\\\Images For Sikuli\\\\SteepedTeaLarge.png");
	Pattern SteepedTeaExtraLarge = new Pattern("C:\\\\Images For Sikuli\\\\SteepedTeaExtraLarge.png");
	Pattern SteepedTeaSmallRefill = new  Pattern("C:\\Images For Sikuli\\SteepedTeaSmallRefill.png");
	Pattern SteepedTeaMediumRefill = new  Pattern("C:\\Images For Sikuli\\SteepedTeaMediumRefill.png");
	Pattern SteepedTeaLargeRefill = new  Pattern("C:\\Images For Sikuli\\SteepedTeaLargeRefill.png");
	Pattern SteepedTeaExtraLargeRefill = new  Pattern("C:\\Images For Sikuli\\SteepedTeaExtraLargeRefill.png");
	Pattern Latte = new  Pattern("C:\\Images For Sikuli\\Latte.png");
	Pattern SmallLatte = new  Pattern("C:\\Images For Sikuli\\SmallLatte.png");
	Pattern SmallRefillLatte =new Pattern("C:\\Images For Sikuli\\SmallRefillLatte.png");
	 
	Pattern MediumLatte =new Pattern("C:\\Images For Sikuli\\MediumLatte.png");
  	Pattern SmallDecaf = new Pattern("C:\\Images For Sikuli\\SmallDecaf.png");
  	Pattern MediumDecaf = new Pattern("C:\\Images For Sikuli\\MediumDecaf.png");
  	Pattern LargeDecaf = new Pattern("C:\\Images For Sikuli\\LargeDecaf.png");
  	Pattern ExtraLargeDecaf = new Pattern("C:\\Images For Sikuli\\ExtraLargeDecaf.png");
  	Pattern SmallDecafRefil = new Pattern("C:\\Images For Sikuli\\SmallDecafRefil.png");
  	Pattern MediumDecafRefil = new Pattern("C:\\Images For Sikuli\\MediumDecafRefil.png");
  	Pattern LargeDecafRefil = new Pattern("C:\\Images For Sikuli\\LargeDecafRefil.png");
  	Pattern LargeLatte = new Pattern("C:\\Images For Sikuli\\LargeLatte.png");
  	//Pattern ExtraLargeDecafRefil = new Pattern("C:\\Images For Sikuli\\ExtraLargeDecafRefil.png");
  	Pattern RefillDecafExtraLarge =new Pattern("C:\\Images For Sikuli\\RefillDecafExtraLarge.png");
  	
  	Pattern IcedBeverages= new Pattern("C:\\Images For Sikuli\\IcedBeverages.png");
 	Pattern IcedCoffee= new Pattern("C:\\Images For Sikuli\\IcedCoffee.png");
 	Pattern OrgIcedCoffee= new Pattern("C:\\Images For Sikuli\\OrgIcedCoffe.png");
  	Pattern MDIcedCoffee= new Pattern("C:\\Images For Sikuli\\MDIcedCoffee.png");
  	
  	Pattern Beverages1 = new Pattern("C:\\Images For Sikuli\\Beverages1.png");
  	Pattern HotBeverages = new Pattern("C:\\Images For Sikuli\\HotBeverages.png");
  	Pattern SpecialtyTea = new Pattern("C:\\Images For Sikuli\\SpecialtyTea.png");
  	Pattern MDTea = new Pattern("C:\\Images For Sikuli\\MDTea.png");
  	Pattern TeaFlav = new Pattern("C:\\Images For Sikuli\\TeaFlav.png");
  	Pattern AppleCinnamon = new Pattern("C:\\Images For Sikuli\\AppleCinnamon.png");
  	Pattern TeaFlav1 = new Pattern("C:\\Images For Sikuli\\TeaFlav1.png");
  	Pattern Picture2 = new Pattern("C:\\Images For Sikuli\\Picture2.png");
  	Pattern VoidItem = new Pattern("C:\\Images For Sikuli\\VoidItem.png");
  	Pattern FlavIcedLatte = new Pattern("C:\\Images For Sikuli\\FlavIcedLatte.png");
  	Pattern VanillaIcedLatte = new Pattern("C:\\Images For Sikuli\\VanillaIcedLatte.png");
  	Pattern VanillaLatteLarge = new Pattern("C:\\Images For Sikuli\\VanillaLatteLarge.png");
  	
  	Pattern Promo = new Pattern("C:\\Images For Sikuli\\Promo.png");
  	Pattern ColdBrew = new Pattern("C:\\Images For Sikuli\\ColdBrew.png");
  	Pattern VanillaCreamColdBrew = new Pattern("C:\\Images For Sikuli\\VanillaCreamColdBrew.png");
  	Pattern VanillaCreamColdBrewSmall = new Pattern("C:\\Images For Sikuli\\VanillaCreamColdBrewSmall.png");
  	
	Pattern ColdBeverages = new Pattern("C:\\Images For Sikuli\\ColdBeverages.png");
  	Pattern BottleWater = new Pattern("C:\\Images For Sikuli\\BottleWater.png");
	Pattern SMCoffee =new Pattern("C:/Images For Sikuli/SMCoffee.png");
  	Pattern MDCoffee = new Pattern("C:/Images For Sikuli/MDCoffee.png");
  	Pattern LGCoffee = new Pattern("C:/Images For Sikuli/LGCoffee.png");
  	Pattern EatIn = new Pattern("C:/Images For Sikuli/EatIn.png"); 
  	
  	
    Screen s;
	public BeverageItems(Screen s) {
		// TODO Auto-generated constructor stub
		this.s =s;
	}
	@Test(priority = 4)
	public void siKuliTestCase004(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		 
		testcase=extent.createTest("TC_004:Verify SMOriginalBlendPrice Price");
		BeverageItems b = new BeverageItems(s);
		 
		 Thread.sleep(2000);
		 s.wait(SMCoffee, 600);  
	     s.click(SMCoffee.similar((float)0.5));
	     testcase.log(Status.PASS, "User able to click on SMCoffee");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "SMOriginalBlendPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readSMOriginalBlendPrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	      /*try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of SM Original Blend Price" );
	    	  System.out.println("***********Scenario04 PASS: Correct ala carte price of SM Original Blend Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of SM Original Blend Price" );
	    	  System.out.println("***********Scenario04 FAIL: Incorrect ala carte price of SM Original Blend Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	@Test(priority = 5)
	  public void siKuliTestCase005(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		testcase=extent.createTest("TC_005:Verify MDCoffee Price");
		BeverageItems b = new BeverageItems(s);
		 
		 
		 Thread.sleep(2000);
		 s.wait(MDCoffee, 300);  
	     s.click(MDCoffee.similar((float)0.5)); 
	     testcase.log(Status.PASS, "User able to click on MDCoffee");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "MDOriginalBlendPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readMdOriginalBlendPrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readMdOriginalBlendPrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of MD Original Blend Price" );
	    	  System.out.println("***********Scenario05 PASS: Correct ala carte price of Md Original Blend Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of MD Original Blend Price" );
	    	  System.out.println("***********Scenario05 FAIL: Incorrect ala carte price of Md Original Blend Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	@Test(priority = 6)
	  public void siKuliTestCase006(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		testcase=extent.createTest("TC_006:Verify LGCoffee Price");
		BeverageItems b = new BeverageItems(s);
		 
		 
		 Thread.sleep(2000); 
		 s.wait(LGCoffee, 300);  
	     s.click(LGCoffee.similar((float)0.5)); 
	     testcase.log(Status.PASS, "User able to click on LGCoffee");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     testcase.log(Status.PASS, "User able to click on EatIn");
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "LGOriginalBlendPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readLGOriginalBlendPrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readLGOriginalBlendPrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of LG Original Blend Price" );
	    	  System.out.println("***********Scenario06 PASS: Correct ala carte price of Large Original Blend Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," InCorrect ala carte price of LG Original Blend Price" );
	    	  System.out.println("***********Scenario06 FAIL: Incorrect ala carte price of Large Original Blend Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	
	@Test(priority = 7)
	  public void siKuliTestCase007(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		testcase=extent.createTest("TC_007:Verify RefillSmallOriginalBlend Price");
		BeverageItems b = new BeverageItems(s);
		 
		 
		 Thread.sleep(2000);
		
		 s.wait(OriginalBlend,300);
		 s.click(OriginalBlend.similar((float)0.5));
		 s.wait(RefillSmallOriginalBlend,300);
		 s.click(RefillSmallOriginalBlend.similar((float)0.5)); 
		 testcase.log(Status.PASS, "User able to click on RefillSmallOriginalBlend");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     testcase.log(Status.PASS, "User able to click on EatIn");
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "RFSMOriginalBlendPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readRefillSmallCoffeePrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readRefillSmallCoffeePrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of Small Refill Original Blend Price" );
	    	  System.out.println("***********Scenario07 PASS: Correct ala carte price of Small Refill Original Blend Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of Small Refill Original Blend Price" );
	    	  System.out.println("***********Scenario07 FAIL: Incorrect ala carte price of Small Refill Original Blend Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	@Test(priority = 8)
	  public void siKuliTestCase008(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		testcase=extent.createTest("TC_008:Verify RefillMediumOriginalBlend Price"); 
		BeverageItems b = new BeverageItems(s);
		 
		 
		 Thread.sleep(2000);
		 
		 s.wait(OriginalBlend,300);
		 s.click(OriginalBlend.similar((float)0.5));
		 s.wait(RefillMediumOriginalBlend,300);
		 s.click(RefillMediumOriginalBlend.similar((float)0.5)); 
		 testcase.log(Status.PASS, "User able to click on RefillMediumOriginalBlend");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     testcase.log(Status.PASS, "User able to click on EatIn");
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "RFMDOriginalBlendPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readRefillMediumCoffeePrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readRefillMediumCoffeePrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of Medium Refill Original Blend Price" );
	    	  System.out.println("***********Scenario08 PASS: Correct ala carte price of Medium Refill Original Blend Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of Medium Refill Original Blend Price" );
	    	  System.out.println("***********Scenario08 FAIL: Incorrect ala carte price of Medium Refill Original Blend Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	
	@Test(priority = 9)
	  public void siKuliTestCase009(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		testcase=extent.createTest("TC_009:Verify RefillLargeOriginalBlend Price");  
		BeverageItems b = new BeverageItems(s);
		 
		 
		 Thread.sleep(2000);
		 
		 s.wait(OriginalBlend,300);
		 s.click(OriginalBlend.similar((float)0.5));
		 s.wait(RefillLargeOriginalBlend,300);
		 s.click(RefillLargeOriginalBlend.similar((float)0.5)); 
		 testcase.log(Status.PASS, "User able to click on RefillLargeOriginalBlend");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     testcase.log(Status.PASS, "User able to click on EatIn");
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "RFLGOriginalBlendPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readRefillLargeCoffeePrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readRefillLargeCoffeePrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of Large Refill Original Blend Price" );
	    	  System.out.println("***********Scenario09 PASS: Correct ala carte price of Large Refill Original Blend Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of Large Refill Original Blend Price" );
	    	  System.out.println("***********Scenario09 FAIL: Incorrect ala carte price of Large Refill Original Blend Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	

	@Test(priority = 10)
	  public void siKuliTestCase010(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		testcase=extent.createTest("TC_010:Verify SmallDarkRoast Price");  
		BeverageItems b = new BeverageItems(s);
		 
		 
		 
		 Thread.sleep(2000);
		 
		 s.wait(DarkRoast,300);
		 s.click(DarkRoast.similar((float)0.5));
		 s.wait(SmallDarkRoast,300);
		 s.click(SmallDarkRoast.similar((float)0.5)); 
		 testcase.log(Status.PASS, "User able to click on SmallDarkRoast");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     testcase.log(Status.PASS, "User able to click on EatIn");
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "SMDarkRoastPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readSmallDarkRoastPrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readSmallDarkRoastPrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of Small Dark Roast Coffee Price" );
	    	  System.out.println("***********Scenario010 PASS: Correct ala carte price of Small Dark Roast Coffee Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of Small Dark Roast Coffee Price" );
	    	  System.out.println("***********Scenario010 FAIL: Incorrect ala carte price of Small Dark Roast Coffee Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	@Test(priority = 11)
	  public void siKuliTestCase011(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		testcase=extent.createTest("TC_011:Verify MediumDarkRoast Price");   
		BeverageItems b = new BeverageItems(s);
		 
		 
		 
		 Thread.sleep(2000);
		 
		 s.wait(DarkRoast,300);
		 s.click(DarkRoast.similar((float)0.5));
		 s.wait(MediumDarkRoast,300);
		 s.click(MediumDarkRoast.similar((float)0.5)); 
		 testcase.log(Status.PASS, "User able to click on MediumDarkRoast");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     testcase.log(Status.PASS, "User able to click on EatIn");
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "MDDarkRoastPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readMediumDarkRoastPrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readMediumDarkRoastPrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of Medium Dark Roast Coffee Price" );
	    	  System.out.println("***********Scenario011 PASS: Correct ala carte price of Medium Dark Roast Coffee Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," InCorrect ala carte price of Medium Dark Roast Coffee Price" );
	    	  System.out.println("***********Scenario011 FAIL: Incorrect ala carte price of Medium Dark Roast Coffee Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	@Test(priority = 12)
	  public void siKuliTestCase012(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		testcase=extent.createTest("TC_012:Verify LargeDarkRoast Price");   
		BeverageItems b = new BeverageItems(s);
		 
		
		 
		 Thread.sleep(2000);
		 
		 s.wait(DarkRoast,300);
		 s.click(DarkRoast.similar((float)0.5));
		 s.wait(LargeDarkRoast,300);
		 s.click(LargeDarkRoast.similar((float)0.5)); 
		 testcase.log(Status.PASS, "User able to click on LargeDarkRoast");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     testcase.log(Status.PASS, "User able to click on EatIn");
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "LGDarkRoastPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readLargeDarkRoastPrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readLargeDarkRoastPrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of Large Dark Roast Coffee Price" );
	    	  System.out.println("***********Scenario12 PASS: Correct ala carte price of Large Dark Roast Coffee Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of Large Dark Roast Coffee Price" );
	    	  System.out.println("***********Scenario12 FAIL: Incorrect ala carte price of Large Dark Roast Coffee Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	      
	  }
	
	@Test(priority = 13)
	  public void siKuliTestCase013(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		 
		testcase=extent.createTest("TC_013:Verify SmallRefillDarkRoast Price");    
		BeverageItems b = new BeverageItems(s);
		 
		 
		 Thread.sleep(2000);
		 
		 s.wait(DarkRoast,300);
		 s.click(DarkRoast.similar((float)0.5));
		 s.wait(SmallRefillDarkRoast,300);
		 s.click(SmallRefillDarkRoast.similar((float)0.5)); 
		 testcase.log(Status.PASS, "User able to click on SmallRefillDarkRoast");
	     s.click(EatIn.similar((float)0.8));
	     testcase.log(Status.PASS, "User able to click on EatIn");
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "RFSMDarkRoastPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readSmallRefillDarkRoastPrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readSmallRefillDarkRoastPrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of Small Refill Dark Roast Coffee Price" );
	    	  System.out.println("***********Scenario13 PASS: Correct ala carte price of Small Refill Dark Roast Coffee Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of Small Refill Dark Roast Coffee Price" );
	    	  System.out.println("***********Scenario13 FAIL: Incorrect ala carte price of Small Refill Dark Roast Coffee Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	@Test(priority = 14)
	  public void siKuliTestCase014(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		testcase=extent.createTest("TC_014:Verify SmallSpecialtyTea Price");    
		BeverageItems b = new BeverageItems(s);
		 
		 
		 
		 Thread.sleep(2000); 
		 s.wait(SpecialtyTea, 300);  
	     s.click(SpecialtyTea.similar((float)0.5)); 
	     
	     s.wait(SmallSpecialtyTea, 300);  
	     s.click(SmallSpecialtyTea.similar((float)0.5));
	     testcase.log(Status.PASS, "User able to click on SmallSpecialtyTea");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     testcase.log(Status.PASS, "User able to click on EatIn");
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "SMSpecialityPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readSmallSpecialityTeaPrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readSmallSpecialityTeaPrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of SM Speciality Tea Price" );
	    	  System.out.println("***********Scenario06 PASS: Correct ala carte price of SM Speciality Tea Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of SM Speciality Tea Price" );
	    	  System.out.println("***********Scenario06 FAIL: Incorrect ala carte price of SM Speciality Tea Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	@Test(priority =15)
	  public void siKuliTestCase015(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		testcase=extent.createTest("TC_015:Verify MediumSpecialtyTea Price"); 
		BeverageItems b = new BeverageItems(s);
		 
		 
		 
		 Thread.sleep(2000); 
		 s.wait(SpecialtyTea, 300);  
	     s.click(SpecialtyTea.similar((float)0.5)); 
	     
	     s.wait(MediumSpecialtyTea, 300);  
	     s.click(MediumSpecialtyTea.similar((float)0.5));
	     testcase.log(Status.PASS, "User able to click on MediumSpecialtyTea");
	     s.wait(EatIn, 300);  
	     s.click(EatIn.similar((float)0.8));
	     testcase.log(Status.PASS, "User able to click on EatIn");
	     Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "MDSpecialityPrice");
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(imagePath));
	      System.out.println(imageText);
	      System.out.println(b.readMediumSpecialityTeaPrice());
	      String a1=null;
	      String a2=null;
	      
	      String replaceAll = imageText.replaceAll("\\s","");
	       a1 = replaceAll;
  	   a2 = b.readMediumSpecialityTeaPrice();
  	   System.out.println(a1);
  	   System.out.println(a2);
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	    	   a1 = parseInt;
	    	   a2 = b.readMdOriginalBlendPrice();
	    	   	    	   
	    	} 
	      catch(NumberFormatException ex)
	      { 
	    	  System.out.println(parseInt);
	    	  System.out.println("Exception Handled"); 
	    	}
	      System.out.println(a1);
	      System.out.println(a2);
	      
	     /* try{
	    	  parseInt = Integer.parseInt(imageText);
	      }
	      catch(NumberFormatException ex){
	    	  System.out.println("Exception Handled");
	      }*/
	      
	      if(a1.equals(a2)){
	    	  testcase.log(Status.PASS," Correct ala carte price of MD Speciality Tea Price" );
	    	  System.out.println("***********Scenario015 PASS: Correct ala carte price of MD Speciality Tea Price ***********");
	      }else{
	    	  testcase.log(Status.FAIL," Incorrect ala carte price of MD Speciality Tea Price" );
	    	  System.out.println("***********Scenario015 FAIL: Incorrect ala carte price of MD Speciality Tea Price ***********");
	    	  
	      }
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }
	@Test(priority = 16)
	public void sikuliTestCase016(ExtentReports extent, ExtentTest testcase)throws FindFailed, IOException, TesseractException, InterruptedException
	{
		testcase=extent.createTest("TC_016:Verify SteepedTeaSmall Price");
		BeverageItems b = new BeverageItems(s);
		 
		 
		 
		 Thread.sleep(2000);
		 s.wait(SteepedTea, 300);
		 s.click(SteepedTea.similar((float)0.5));
		 
		 s.wait(SteepedTeaSmall, 300);
		 s.click(SteepedTeaSmall.similar((float)0.5));
		 testcase.log(Status.PASS, "User able to click on SteepedTeaSmall");
		 s.wait(EatIn, 300);  
		 s.click(EatIn.similar((float)0.8));
		 testcase.log(Status.PASS, "User able to click on EatIn");
		 Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "SMSteepedTeaPrice");
		 ITesseract image = new Tesseract();
		 image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
		 String imageText=image.doOCR(new File(imagePath));
		 System.out.println(imageText);
		 System.out.println(b.readSteepedTeaSmallPrice());
		 String a1=null;
		 String a2=null;
		 
		 String replaceAll = imageText.replaceAll("\\s","");
		 a1 = replaceAll;
		 a2 = b.readSteepedTeaSmallPrice();
		 System.out.println(a1);
		 System.out.println(a2);
		 
		 if(a1.equals(a2)){
			 testcase.log(Status.PASS," Correct ala carte price of SM Steeped Tea Price" );
		 System.out.println("***********Scenario016 PASS: Correct ala carte price of SM Steeped Tea Price ***********");
		}
		 else
		 {
			 testcase.log(Status.FAIL," Incorrect ala carte price of SM Steeped Tea Price" );
		 System.out.println("***********Scenario016 FAIL: Incorrect ala carte price of SM Steeped Tea Price ***********");
		}
		 s.wait(VoidItem, 300);
		 s.click(VoidItem.similar((float)0.5));
	 }
	@Test(priority = 17)
	public void sikuliTestCase017(ExtentReports extent, ExtentTest testcase)throws FindFailed, IOException, TesseractException, InterruptedException
	{
		testcase=extent.createTest("TC_017:Verify SteepedTeaMedium Price"); 
		BeverageItems b = new BeverageItems(s);
		 
		 
		 
		 Thread.sleep(2000);
		 s.wait(SteepedTea, 300);
		 s.click(SteepedTea.similar((float)0.5));
		 
		 s.wait(SteepedTeaMedium, 300);
		 s.click(SteepedTeaMedium.similar((float)0.5));
		 testcase.log(Status.PASS, "User able to click on SteepedTeaMedium");
		 s.wait(EatIn, 300);  
		 s.click(EatIn.similar((float)0.8));
		 testcase.log(Status.PASS, "User able to click on EatIn");
		 Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "MDSteepedTeaPrice");
		 ITesseract image = new Tesseract();
		 image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
		 String imageText=image.doOCR(new File(imagePath));
		 System.out.println(imageText);
		 System.out.println(b.readSteepedTeaMediumPrice());
		 String a1=null;
		 String a2=null;
		 
		 String replaceAll = imageText.replaceAll("\\s","");
		 a1 = replaceAll;
		 a2 = b.readSteepedTeaMediumPrice();
		 System.out.println(a1);
		 System.out.println(a2);
		 
		 if(a1.equals(a2)){
			 testcase.log(Status.PASS," Correct ala carte price of MD Steeped Tea Price" );
		 System.out.println("***********Scenario017 PASS: Correct ala carte price of MD Steeped Tea Price ***********");
		}
		 else
		 {
			 testcase.log(Status.FAIL," Incorrect ala carte price of MD Steeped Tea Price" );
		 System.out.println("***********Scenario017 FAIL: Incorrect ala carte price of MD Steeped Tea Price ***********");
		}
		 s.wait(VoidItem, 300);
		 s.click(VoidItem.similar((float)0.5));
	 }
	@Test(priority = 18)
	public void sikuliTestCase018(ExtentReports extent, ExtentTest testcase)throws FindFailed, IOException, TesseractException, InterruptedException
	{
		testcase=extent.createTest("TC_018:Verify SteepedTeaLarge Price"); 
		BeverageItems b = new BeverageItems(s);
		 
		 
		 
		 Thread.sleep(2000);
		 s.wait(SteepedTea, 300);
		 s.click(SteepedTea.similar((float)0.5));
		 
		 s.wait(SteepedTeaLarge, 300);
		 s.click(SteepedTeaLarge.similar((float)0.5));
		 testcase.log(Status.PASS, "User able to click on SteepedTeaLarge");
		 s.wait(EatIn, 300);  
		 s.click(EatIn.similar((float)0.8));
		 testcase.log(Status.PASS, "User able to click on EatIn");
		 Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "LGSteepedTeaPrice");
		 ITesseract image = new Tesseract();
		 image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
		 String imageText=image.doOCR(new File(imagePath));
		 System.out.println(imageText);
		 System.out.println(b.readSteepedTeaLargePrice());
		 String a1=null;
		 String a2=null;
		 
		 String replaceAll = imageText.replaceAll("\\s","");
		 a1 = replaceAll;
		 a2 = b.readSteepedTeaLargePrice();
		 System.out.println(a1);
		 System.out.println(a2);
		 
		 if(a1.equals(a2)){
			 testcase.log(Status.PASS," Correct ala carte price of LG Steeped Tea Price" );
		 System.out.println("***********Scenario018 PASS: Correct ala carte price of LG Steeped Tea Price ***********");
		}
		 else
		 {
			 testcase.log(Status.FAIL," Incorrect ala carte price of LG Steeped Tea Price" );
		 System.out.println("***********Scenario018 FAIL: Incorrect ala carte price of LG Steeped Tea Price ***********");
		}
		 s.wait(VoidItem, 300);
		 s.click(VoidItem.similar((float)0.5));
	 }
	
	/*@Test(priority = 11)
	public void sikuliTestCase00011()throws FindFailed, IOException, TesseractException, InterruptedException
	{
		testcase=extent.createTest("TC_0011:Verify TEA STEEPED ORANGE XL Price");
		 
		 RegressionTest14feb b = new RegressionTest14feb();
		 
		 Thread.sleep(2000);
		 s.wait(SteepedTea, 300);
		 s.click(SteepedTea.similar((float)0.5));
		 (Status.PASS, "User able to Click the SteepedTea Button");
		 s.wait(SteepedTeaExtraLarge, 300);
		 s.click(SteepedTeaExtraLarge.similar((float)0.5));
		 (Status.PASS, "User able to Click the LargeSteepedTea Button");
		 s.wait(EatIn, 300);  
		 s.click(EatIn.similar((float)0.8));
		 (Status.PASS, "User able to Click the Eatin Button");
		 File Source = new File("SteepedTeaExtraLargePrice.png");
		 String Path = System.getProperty("user.dir")+"/Images/SteepedTeaExtraLargePrice.png";
		 FileHandler.copy(Source, new File(Path));
		 ITesseract image = new Tesseract();
		 image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
		 String imageText=image.doOCR(new File(Path));
		 System.out.println(imageText);
		 System.out.println(b.readSteepedTeaExtraLargePrice());
		 String a1=null;
		 String a2=null;
		 
		 String replaceAll = imageText.replaceAll("\\s","");
		 a1 = replaceAll;
		 a2 = b.readSteepedTeaExtraLargePrice();
		 System.out.println(a1);
		 System.out.println(a2);
		 
		 if(a1.equals(a2)){
		 (Status.PASS," Correct ala carte price of XL Steeped Tea Price" );
		 System.out.println("***********Scenario011 PASS: Correct ala carte price of XL Steeped Tea Price ***********");
		}
		 else
		 {
		(Status.FAIL, "Incorrect ala carte price of XL Steeped Tea Price");
		 System.out.println("***********Scenario011 FAIL: Incorrect ala carte price of XL Steeped Tea Price ***********");
		}
		 s.wait(VoidItem, 300);
		 s.click(VoidItem.similar((float)0.5));
	 }*/


	
@Test(priority = 19)
public void sikuliTestCase019(ExtentReports extent, ExtentTest testcase)throws FindFailed, IOException, TesseractException, InterruptedException
{

	testcase=extent.createTest("TC_019:Verify SteepedTeaSmallRefill Price"); 
BeverageItems b = new BeverageItems(s);

Thread.sleep(2000);
s.wait(SteepedTea, 300);
s.click(SteepedTea.similar((float)0.5));

s.wait(SteepedTeaSmallRefill, 300);
s.click(SteepedTeaSmallRefill.similar((float)0.5));
testcase.log(Status.PASS, "User able to click on SteepedTeaSmallRefill");
s.wait(EatIn, 300);  
s.click(EatIn.similar((float)0.8));
testcase.log(Status.PASS, "User able to click on EatIn");
Thread.sleep(4000);
Rectangle rectangle=new Rectangle();
rectangle.setBounds(420,200,60,30);
String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "RFSMSteepedTeaPrice");
ITesseract image = new Tesseract();
image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
String imageText=image.doOCR(new File(imagePath));
System.out.println(imageText);
System.out.println(b.readSteepedTeaSmallRefillPrice());
String a1=null;
String a2=null;

String replaceAll = imageText.replaceAll("\\s","");
a1 = replaceAll;
a2 = b.readSteepedTeaSmallRefillPrice();
System.out.println(a1);
System.out.println(a2);

if(a1.equals(a2)){
	testcase.log(Status.PASS," Correct ala carte price of RF-SM Steeped Tea Price" );
System.out.println("***********Scenario019 PASS: Correct ala carte price of RF-SM Steeped Tea Price ***********");
}
else
{
	testcase.log(Status.FAIL," Incorrect ala carte price of RF-SM Steeped Tea Price" );
System.out.println("***********Scenario019 FAIL: Incorrect ala carte price of RF-SM Steeped Tea Price ***********");
}
s.wait(VoidItem, 300);
s.click(VoidItem.similar((float)0.5));
}

@Test(priority = 20)
public void sikuliTestCase020(ExtentReports extent, ExtentTest testcase)throws FindFailed, IOException, TesseractException, InterruptedException
{

	testcase=extent.createTest("TC_020:Verify SteepedTeaMediumRefill Price");
	BeverageItems b = new BeverageItems(s);
	 

Thread.sleep(2000);
s.wait(SteepedTea, 300);
s.click(SteepedTea.similar((float)0.5));

s.wait(SteepedTeaMediumRefill, 300);
s.click(SteepedTeaMediumRefill.similar((float)0.5));
testcase.log(Status.PASS, "User able to click on SteepedTeaMediumRefill");
s.wait(EatIn, 300);  
s.click(EatIn.similar((float)0.8));
testcase.log(Status.PASS, "User able to click on EatIn");
Thread.sleep(4000);
Rectangle rectangle=new Rectangle();
rectangle.setBounds(420,200,60,30);
String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "RFSMSteepedTeaPrice");
ITesseract image = new Tesseract();
image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
String imageText=image.doOCR(new File(imagePath));
System.out.println(imageText);
System.out.println(b.readSteepedTeaMediumRefillPrice());
String a1=null;
String a2=null;

String replaceAll = imageText.replaceAll("\\s","");
a1 = replaceAll;
a2 = b.readSteepedTeaMediumRefillPrice();
System.out.println(a1);
System.out.println(a2);

if(a1.equals(a2)){
	testcase.log(Status.PASS," Correct ala carte price of RF-MD Steeped Tea Price" );
System.out.println("***********Scenario020 PASS: Correct ala carte price of RF-MD Steeped Tea Price ***********");
}
else
{
	testcase.log(Status.FAIL," Incorrect ala carte price of RF-MD Steeped Tea Price" );
System.out.println("***********Scenario020 FAIL: Incorrect ala carte price of RF-MD Steeped Tea Price ***********");
}
s.wait(VoidItem, 300);
s.click(VoidItem.similar((float)0.5));
}

/*@Test(priority = 21)
public void sikuliTestCase021()throws FindFailed, IOException, TesseractException, InterruptedException
{

	testcase=extent.createTest("TC_021:Verify SteepedTeaLargeRefill Price");
Runner b = new Runner();

Thread.sleep(2000);
s.wait(SteepedTea, 300);
s.click(SteepedTea.similar((float)0.5));

s.wait(SteepedTeaLargeRefill, 300);
s.click(SteepedTeaLargeRefill.similar((float)0.5));

s.wait(EatIn, 300);  
s.click(EatIn.similar((float)0.8));

Thread.sleep(4000);
Rectangle rectangle=new Rectangle();
rectangle.setBounds(420,200,60,30);
String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "RFLGSteepedTeaPrice");
ITesseract image = new Tesseract();
image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
String imageText=image.doOCR(new File(imagePath));
System.out.println(imageText);
System.out.println(b.readSteepedTeaLargeRefillPrice());
String a1=null;
String a2=null;

String replaceAll = imageText.replaceAll("\\s","");
a1 = replaceAll;
a2 = b.readSteepedTeaLargeRefillPrice();
System.out.println(a1);
System.out.println(a2);

if(a1.equals(a2)){

System.out.println("***********Scenario021 PASS: Correct ala carte price of RF-LG Steeped Tea Price ***********");
}
else
{

System.out.println("***********Scenario021 FAIL: Incorrect ala carte price of RF-LG Steeped Tea Price ***********");
}
s.wait(VoidItem, 300);
s.click(VoidItem.similar((float)0.5));
}
/*@Test(priority = 15)
public void sikuliTestCase00015()throws FindFailed, IOException, TesseractException, InterruptedException
{
testcase=extent.createTest("TC_0015:Verify TEA STEEPED ORANGE RF-XL Price");

RegressionTest14feb b = new RegressionTest14feb();

Thread.sleep(2000);
s.wait(SteepedTea, 300);
s.click(SteepedTea.similar((float)0.5));
(Status.PASS, "User able to Click the SteepedTea Button");
s.wait(SteepedTeaExtraLargeRefill, 300);
s.click(SteepedTeaExtraLargeRefill.similar((float)0.5));
(Status.PASS, "User able to Click the SteepedTeaExtraLargeRefill Button");
s.wait(EatIn, 300);  
s.click(EatIn.similar((float)0.8));
(Status.PASS, "User able to Click the Eatin Button");
File Source = new File("SteepedTeaExtraLargeRefillPrice.png");
String Path = System.getProperty("user.dir")+"/Images/SteepedTeaExtraLargeRefillPrice.png";
FileHandler.copy(Source, new File(Path));
ITesseract image = new Tesseract();
image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
String imageText=image.doOCR(new File(Path));
System.out.println(imageText);
System.out.println(b.readSteepedTeaExtraLargeRefillPrice());
String a1=null;
String a2=null;

String replaceAll = imageText.replaceAll("\\s","");
a1 = replaceAll;
a2 = b.readSteepedTeaExtraLargeRefillPrice();
System.out.println(a1);
System.out.println(a2);

if(a1.equals(a2)){
(Status.PASS," Correct ala carte price of RF-MD Steeped Tea Price" );
System.out.println("***********Scenario015 PASS: Correct ala carte price of RF-XL Steeped Tea Price ***********");
}
else
{
(Status.FAIL, "Incorrect ala carte price of RF-MD Steeped Tea Price");
System.out.println("***********Scenario015 FAIL: Incorrect ala carte price of RF-XL Steeped Tea Price ***********");
}
s.wait(VoidItem, 300);
s.click(VoidItem.similar((float)0.5));
}*/

@Test(priority = 21)
public void sikuliTestCase021(ExtentReports extent, ExtentTest testcase)throws FindFailed, IOException, TesseractException, InterruptedException
{

	testcase=extent.createTest("TC_021:Verify SmallLatte Price");
	BeverageItems b = new BeverageItems(s);
	 

Thread.sleep(2000);
s.wait(Latte, 300);
s.click(Latte.similar((float)0.5));

s.wait(SmallLatte, 300);
s.click(SmallLatte.similar((float)0.5));
testcase.log(Status.PASS, "User able to click on SmallLatte");
s.wait(EatIn, 300);  
s.click(EatIn.similar((float)0.8));
testcase.log(Status.PASS, "User able to click on EatIn");
Thread.sleep(4000);
Rectangle rectangle=new Rectangle();
rectangle.setBounds(420,200,60,30);
String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "SMLattePrice");
ITesseract image = new Tesseract();
image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
String imageText=image.doOCR(new File(imagePath));
System.out.println(imageText);
System.out.println(b.readSmallLattePrice());
String a1=null;
String a2=null;

String replaceAll = imageText.replaceAll("\\s","");
a1 = replaceAll;
a2 = b.readSmallLattePrice();
System.out.println(a1);
System.out.println(a2);

if(a1.equals(a2)){
	testcase.log(Status.PASS," Correct ala carte price of SmallLatte Price" );
System.out.println("***********Scenario021 PASS: Correct ala carte price of SmallLatte Price ***********");
}
else
{
	testcase.log(Status.FAIL," Incorrect ala carte price of SmallLatte Price" );
System.out.println("***********Scenario021 FAIL: Incorrect ala carte price of SmallLatte Price ***********");
}
s.wait(VoidItem, 300);
s.click(VoidItem.similar((float)0.5));
}
/*@Test(priority = 17)
public void sikuliTestCase00017()throws FindFailed, IOException, TesseractException, InterruptedException
{
testcase=extent.createTest("TC_0017:Verify LATTE - NM17 MD Price");

RegressionTest14feb b = new RegressionTest14feb();

Thread.sleep(2000);
s.wait(Latte, 300);
s.click(Latte.similar((float)0.5));

s.wait(MediumLatte, 300);
s.click(MediumLatte.similar((float)0.5));
(Status.PASS, "User able to Click the MediumLatte Button");
s.wait(EatIn, 300);  
s.click(EatIn.similar((float)0.8));
(Status.PASS, "User able to Click the Eatin Button");
File Source = new File("MediumLattePrice.png");
String Path = System.getProperty("user.dir")+"/Images/MediumLattePrice.png";
FileHandler.copy(Source, new File(Path));
ITesseract image = new Tesseract();
image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
String imageText=image.doOCR(new File(Path));
System.out.println(imageText);
System.out.println(b.readMediumLattePrice());
String a1=null;
String a2=null;

String replaceAll = imageText.replaceAll("\\s","");
a1 = replaceAll;
a2 = b.readMediumLattePrice();
System.out.println(a1);
System.out.println(a2);

if(a1.equals(a2)){
(Status.PASS," Correct ala carte price of MediumLatte Price" );
System.out.println("***********Scenario017 PASS: Correct ala carte price of MediumLatte Price ***********");
}
else
{
(Status.FAIL, "Incorrect ala carte price of MediumLatte  Price");
System.out.println("***********Scenario017 FAIL: Incorrect ala carte price of MediumLatte Price ***********");
}
s.wait(VoidItem, 300);
s.click(VoidItem.similar((float)0.5));
}*/
@Test(priority = 22)
public void sikuliTestCase022(ExtentReports extent, ExtentTest testcase)throws FindFailed, IOException, TesseractException, InterruptedException
{

	testcase=extent.createTest("TC_022:Verify LargeLatte Price");
	BeverageItems b = new BeverageItems(s);
	 

Thread.sleep(2000);
s.wait(Latte, 300);
s.click(Latte.similar((float)0.5));

s.wait(LargeLatte, 300);
s.click(LargeLatte.similar((float)0.5));
testcase.log(Status.PASS, "User able to click on LargeLatte");
s.wait(EatIn, 300);  
s.click(EatIn.similar((float)0.8));
testcase.log(Status.PASS, "User able to click on EatIn");
Thread.sleep(4000);
Rectangle rectangle=new Rectangle();
rectangle.setBounds(420,200,60,30);
String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "LGLattePrice");
ITesseract image = new Tesseract();
image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
String imageText=image.doOCR(new File(imagePath));
System.out.println(imageText);
System.out.println(b.readLargeLattePrice());
String a1=null;
String a2=null;

String replaceAll = imageText.replaceAll("\\s","");
a1 = replaceAll;
a2 = b.readLargeLattePrice();
System.out.println(a1);
System.out.println(a2);

if(a1.equals(a2)){
	testcase.log(Status.PASS," Correct ala carte price of LargeLatte Price" );
System.out.println("***********Scenario022 PASS: Correct ala carte price of LargeLatte Price ***********");
}
else
{
	testcase.log(Status.FAIL," Incorrect ala carte price of LargeLatte Price" );
System.out.println("***********Scenario022 FAIL: Incorrect ala carte price of LargeLatte Price ***********");
}
s.wait(VoidItem, 300);
s.click(VoidItem.similar((float)0.5));
}

}
