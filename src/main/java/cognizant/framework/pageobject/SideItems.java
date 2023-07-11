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

import excel.Read_Data;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class SideItems extends Read_Data  {
	
	Pattern Cookies = new Pattern("C:\\Images For Sikuli\\Cookies.png");
  	Pattern ChocolateCookies=new Pattern("C:\\Images For Sikuli\\ChocolateCookies.png");
  	Pattern CookiesDozen = new Pattern("C:\\Images For Sikuli\\CookiesDozen.png");
  	Pattern CookAsrtDozen = new Pattern("C:\\Images For Sikuli\\CookAsrtDozen.png");
  	Pattern DoubleChocCookie = new Pattern("C:\\Images For Sikuli\\DoubleChocCookie.png");
  	
  	Pattern Sides = new Pattern("C:/Images For Sikuli/Sides.png");
  	Pattern AssortedDonut = new Pattern("C:/Images For Sikuli/AssortedDonut.png");
  	Pattern AssortedPremiumDonut = new Pattern("C:/Images For Sikuli/AssortedPremiumDonut.png");
  	Pattern Donuts = new Pattern("C:/Images For Sikuli/Donuts.png"); 
  	Pattern ClassicDonut = new Pattern("C:/Images For Sikuli/ClassicDonut.png"); 
  	
  	Pattern Muffin = new Pattern("C:\\Images For Sikuli\\Muffin.png");
  	Pattern BlueberryMuffin = new Pattern("C:\\Images For Sikuli\\BlueberryMuffin.png");
  	Pattern BlueberryTimbits = new Pattern("C:\\Images For Sikuli\\BlueberryTimbits.png");
  	Pattern Timbits = new Pattern("C:\\Images For Sikuli\\Timbits.png");
  	Pattern Timbits10 = new Pattern("C:\\Images For Sikuli\\Timbits10.png");
  	
  	Pattern OtherSides = new Pattern("C:\\Images For Sikuli\\OtherSides.png");
  	Pattern Hashbrown = new Pattern("C:\\Images For Sikuli\\Hashbrown.png");
  	Pattern Functions = new Pattern("C:/Images For Sikuli/Functions.png"); 
  	Pattern MinPOS = new Pattern("C:/Images For Sikuli/MinPOS.png"); 
  	Pattern EatIn = new Pattern("C:/Images For Sikuli/EatIn.png"); 
  	Pattern VoidItem = new Pattern("C:\\Images For Sikuli\\VoidItem.png");
  	
    Screen s;
	public SideItems(Screen s) {
		// TODO Auto-generated constructor stub
		this.s =s;
	}
	
	@Test(priority = 24)
	public void siKuliTestCase024(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	{     
	   

		SideItems b = new SideItems(s);

	   Thread.sleep(2000);
	   
	   s.wait(Sides,300);
	   s.click(Sides.similar((float)0.5));
	   s.wait(AssortedDonut,300);
	   s.click(AssortedDonut.similar((float)0.5));
	   
	   testcase.log(Status.PASS, "User able to click on AssortedDonut");
	   s.wait(EatIn, 300);  
	   s.click(EatIn.similar((float)0.8));
	   testcase.log(Status.PASS, "User able to click on EatIn");
	   Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "AssortedDonutPrice");
	    ITesseract image = new Tesseract();
	    image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	    String imageText=image.doOCR(new File(imagePath));
	    System.out.println(imageText);
	    System.out.println(b.readAssortedDonutPrice());
	    String a1=null;
	    String a2=null;

	    String replaceAll = imageText.replaceAll("\\s","");
	     a1 = replaceAll;
	     a2 = b.readAssortedDonutPrice();
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
	    	testcase.log(Status.PASS," Correct ala carte price of Assorted Donut Price" );
	        System.out.println("***********Scenario24 PASS: Correct ala carte price of Assorted Donut Price ***********");
	    }else{
	    	testcase.log(Status.FAIL," Incorrect ala carte price of Assorted Donut Price" );
	        System.out.println("***********Scenario24 FAIL: Incorrect ala carte price of Assorted Donut Price ***********");
	        
	    }
	    s.wait(VoidItem, 300);
	    s.click(VoidItem.similar((float)0.5));
	}
	@Test(priority = 25)
	public void siKuliTestCase025(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	{     
	   

		SideItems b = new SideItems(s);

	   Thread.sleep(2000);
	   
	   s.wait(Sides,300);
	   s.click(Sides.similar((float)0.5));
	   s.wait(AssortedPremiumDonut,300);
	   s.click(AssortedPremiumDonut.similar((float)0.5)); 
	   testcase.log(Status.PASS, "User able to click on AssortedPremiumDonut");
	   s.wait(EatIn, 300);  
	   s.click(EatIn.similar((float)0.8));
	   testcase.log(Status.PASS, "User able to click on EatIn");
	   Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "AssortedPremiumDonutPrice");
	    ITesseract image = new Tesseract();
	    image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	    String imageText=image.doOCR(new File(imagePath));
	    System.out.println(imageText);
	    System.out.println(b.readAssortedPremiumPrice());
	    String a1=null;
	    String a2=null;

	    String replaceAll = imageText.replaceAll("\\s","");
	     a1 = replaceAll;
	     a2 = b.readAssortedPremiumPrice();
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
	    	testcase.log(Status.PASS," Correct ala carte price of Assorted Premium Donut Price" );
	        System.out.println("***********Scenario25 PASS: Correct ala carte price of Assorted Premium Donut Price ***********");
	    }else{
	    	testcase.log(Status.FAIL," Incorrect ala carte price of Assorted Premium Donut Price" );
	        System.out.println("***********Scenario25 FAIL: Incorrect ala carte price of Assorted Premium Donut Price ***********");
	        
	    }
	    s.wait(VoidItem, 300);
	    s.click(VoidItem.similar((float)0.5));
	}
	@Test(priority = 26)
	public void siKuliTestCase026(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	{     
	   

		SideItems b = new SideItems(s);

	   Thread.sleep(2000);
	   
	   s.wait(Sides,300);
	   s.click(Sides.similar((float)0.5));
	   s.wait(Timbits,300);
	   s.click(Timbits.similar((float)0.5)); 
	   s.wait(BlueberryTimbits,300);
	   s.click(BlueberryTimbits.similar((float)0.5)); 
	   testcase.log(Status.PASS, "User able to click on BlueberryTimbits");
	   s.wait(EatIn, 300);  
	   s.click(EatIn.similar((float)0.8));
	   testcase.log(Status.PASS, "User able to click on EatIn");
	   Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "BlueberryTimbitPrice");
	    ITesseract image = new Tesseract();
	    image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	    String imageText=image.doOCR(new File(imagePath));
	    System.out.println(imageText);
	    System.out.println(b.readBlueberryTimbitPrice());
	    String a1=null;
	    String a2=null;

	    String replaceAll = imageText.replaceAll("\\s","");
	     a1 = replaceAll;
	     a2 = b.readBlueberryTimbitPrice();
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
	    	testcase.log(Status.PASS," Correct ala carte price of BlueberryTimbit Price" );
	        System.out.println("***********Scenario26 PASS: Correct ala carte price of BlueberryTimbit Price ***********");
	    }else{
	    	testcase.log(Status.FAIL," Correct ala carte price of BlueberryTimbit Price" );
	        System.out.println("***********Scenario26 FAIL: Incorrect ala carte price of Blueberry Timbit Price ***********");
	        
	    }
	    s.wait(VoidItem, 300);
	    s.click(VoidItem.similar((float)0.5));
	}
	@Test(priority = 27)
	public void siKuliTestCase027(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	{     
	   

		SideItems b = new SideItems(s);

	   Thread.sleep(2000);
	   
	   s.wait(Sides,300);
	   s.click(Sides.similar((float)0.5));
	   s.wait(Muffin,300);
	   s.click(Muffin.similar((float)0.5)); 
	   s.wait(BlueberryMuffin,300);
	   s.click(BlueberryMuffin.similar((float)0.5)); 
	   testcase.log(Status.PASS, "User able to click on BlueberryMuffin");
	   s.wait(EatIn, 300);  
	   s.click(EatIn.similar((float)0.8));
	   testcase.log(Status.PASS, "User able to click on EatIn");
	   Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "BlueberryMuffinPrice");
	    ITesseract image = new Tesseract();
	    image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	    String imageText=image.doOCR(new File(imagePath));
	    System.out.println(imageText);
	    System.out.println(b.readBlueberryMuffinPrice());
	    String a1=null;
	    String a2=null;

	    String replaceAll = imageText.replaceAll("\\s","");
	     a1 = replaceAll;
	     a2 = b.readBlueberryMuffinPrice();
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
	    	testcase.log(Status.PASS," Correct ala carte price of Blueberry Muffin Price" );
	        System.out.println("***********Scenario27 PASS: Correct ala carte price of Blueberry Muffin Price ***********");
	    }else{
	    	testcase.log(Status.FAIL," Incorrect ala carte price of Blueberry Muffin Price" );
	        System.out.println("***********Scenario27 FAIL: Incorrect ala carte price of Blueberry Muffin Price ***********");
	        
	    }
	    s.wait(VoidItem, 300);
	    s.click(VoidItem.similar((float)0.5));
	}
	@Test(priority = 28)
	public void siKuliTestCase028(ExtentReports extent, ExtentTest testcase) throws FindFailed, IOException, TesseractException, InterruptedException 
	{     
	   

		SideItems b = new SideItems(s);

	   Thread.sleep(2000);
	   
	   s.wait(Sides,300);
	   s.click(Sides.similar((float)0.5));
	   s.wait(Cookies,300);
	   s.click(Cookies.similar((float)0.5)); 
	   s.wait(ChocolateCookies,300);
	   s.click(ChocolateCookies.similar((float)0.5)); 
	   testcase.log(Status.PASS, "User able to click on ChocolateCookies");
	   s.wait(EatIn, 300);  
	   s.click(EatIn.similar((float)0.8));
	   testcase.log(Status.PASS, "User able to click on EatIn");
	   Thread.sleep(4000);
		  Rectangle rectangle=new Rectangle();
		  rectangle.setBounds(420,200,60,30);
		  String imagePath  = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "ChocolateCookiesPrice");
	    ITesseract image = new Tesseract();
	    image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	    String imageText=image.doOCR(new File(imagePath));
	    System.out.println(imageText);
	    System.out.println(b.readChocolateCookiesPrice());
	    String a1=null;
	    String a2=null;

	    String replaceAll = imageText.replaceAll("\\s","");
	     a1 = replaceAll;
	     a2 = b.readChocolateCookiesPrice();
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
	    	testcase.log(Status.PASS," Correct ala carte price of ChocolateCookies Price " );
	        System.out.println("***********Scenario20 PASS: Correct ala carte price of ChocolateCookies Price ***********");
	    }else{
	    	testcase.log(Status.FAIL," Incorrect ala carte price of ChocolateCookies Price " );
	        System.out.println("***********Scenario20 FAIL: Incorrect ala carte price of ChocolateCookiesPrice ***********");
	        
	    }
	    s.wait(VoidItem, 300);
	    s.click(VoidItem.similar((float)0.5));
	}
// Testing Git 
}
