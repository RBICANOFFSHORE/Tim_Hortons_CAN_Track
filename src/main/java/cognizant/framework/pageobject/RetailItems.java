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

import com.aventstack.extentreports.Status;
//import com.testcases.framework.BomgarTestCases;
//import com.testcases.framework.BomgarTestScenerio;
import com.testcases.framework.Runner;

import excel.Read_Data;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class RetailItems extends Read_Data {
	
	Pattern Retail = new Pattern("C:/Images For Sikuli/Retail.png"); 
  	Pattern TakeHome = new Pattern("C:/Images For Sikuli/TakeHome.png"); 
  	Pattern Consumables = new Pattern("C:/Images For Sikuli/Consumables.png"); 
  	Pattern MapleButter = new Pattern("C:/Images For Sikuli/MapleButter.png"); 
  	Pattern Hardware = new Pattern("C:\\Images For Sikuli\\Hardware.png");
  	Pattern Mugs = new Pattern("C:\\Images For Sikuli\\Mugs.png");
  	Pattern CeramicMug = new Pattern("C:\\Images For Sikuli\\CeramicMug.png");
  	
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
	public RetailItems(Screen s) {
		// TODO Auto-generated constructor stub
		this.s =s;
	}
	
	@Test(priority = 30)
	  public void siKuliTestCase030() throws FindFailed, IOException, TesseractException, InterruptedException 
	  {	 
		 
		 
		RetailItems b = new RetailItems(s);
		 
		    Thread.sleep(3000);
		    s.wait(Retail, 300);  
	        s.click(Retail.similar((float)0.5));
	        
	        Thread.sleep(2000); 
	        s.wait(TakeHome, 300);  
	        s.click(TakeHome.similar((float)0.5)); 
	        
	        Thread.sleep(2000); 
	        s.wait(Consumables, 300);  
	        s.click(Consumables.similar((float)0.5));
	        
	        Thread.sleep(2000); 
	        s.wait(MapleButter, 300);  
	        s.click(MapleButter.similar((float)0.5));
	        
	        s.wait(EatIn, 300);  
	        s.click(EatIn.similar((float)0.8));
	        
	      File Source = new File("MapleButterPrice.png");
	      String Path = System.getProperty("user.dir")+"/Images/MapleButterPrice.png";
	      FileHandler.copy(Source, new File(Path));
	      ITesseract image = new Tesseract();
	      image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
	      String imageText=image.doOCR(new File(Path));
	      SoftAssert soft = new SoftAssert();
	      soft.assertEquals(imageText, b.readMapleButterPrice());
	      
	      System.out.println("***************************************Scenario 09 PASS: Retail item Price is correct****************************");
	      s.wait(VoidItem, 300);
	      s.click(VoidItem.similar((float)0.5));
	  }

}
