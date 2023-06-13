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
import com.testcases.framework.Runner;

import excel.Read_Data;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;




public class LandingPage extends Read_Data{
	
	
	Pattern Functions = new Pattern("C:/Images For Sikuli/Functions.png"); 
	Pattern BomgarApp = new Pattern("C:/Images For Sikuli/BomgarDesktop.png");
  	Pattern BomgarLogin = new Pattern("C:/Images For Sikuli/BomgarLogin.png");   
  	Pattern QSTT2Login = new Pattern("C:/Images For Sikuli/QSTT2Login.png");  
  	Pattern ScreenSharing = new Pattern("C:/Images For Sikuli/ScreenSharing.png");  
  	Pattern RollbackLightTaskbar = new Pattern("C:/Images For Sikuli/RollbackLightTaskbar.png");  
  	Pattern IQTouchTaskbar = new Pattern("C:/Images For Sikuli/IQTouchTaskbar.png");  
  	Pattern RollbackLightDesktop = new Pattern("C:/Images For Sikuli/RollbackLightDesktop.png"); 
  	Pattern RollbackLightDesktop1 = new Pattern("C:/Images For Sikuli/RollbackLightDesktop1.png");  
  	Pattern CloseWindow = new Pattern("C:/Images For Sikuli/CloseWindow.png");  
  	Pattern StoreNumber = new Pattern("C:/Images For Sikuli/StoreNumber.png");  
  	Pattern ReleaseID = new Pattern("C:/Images For Sikuli/ReleaseID.png");  
  	Pattern RollbackApply = new Pattern("C:/Images For Sikuli/RollbackApply.png");  
  	Pattern TabPOS = new Pattern("C:/Images For Sikuli/TabPOS.png"); 
  	Pattern OkRollbackQST = new Pattern("C:/Images For Sikuli/OkRollbackQST.png");  
  	Pattern CloseTerminal = new Pattern("C:/Images For Sikuli/CloseTerminal.png");  
  	Pattern EndSession = new Pattern("C:/Images For Sikuli/EndSession.png");  
  	//Pattern TasksRunning = new Pattern("C:/Images For Sikuli/TasksRunning.png");  
  	//Pattern BomgarTask = new Pattern("C:/Images For Sikuli/BomgarTask.png");  
  	Pattern QuitBomgar = new Pattern("C:/Images For Sikuli/QuitBomgar.png");  
  	//Pattern LogoutBomgar = new Pattern("C:/Images For Sikuli/LogoutBomgar.png");  
  	Pattern YesBomgar = new Pattern("C:/Images For Sikuli/YesBomgar.png");  
  	Pattern File = new Pattern("C:/Images For Sikuli/File.png"); 
  	Pattern UpdateQST = new Pattern("C:\\Images For Sikuli\\UpdateQST.png"); 
  	Pattern ViewMgrUpdate = new Pattern("C:/Images For Sikuli/ViewMgrUpdate.png"); 
  	Pattern ApplyUpdates = new Pattern("C:/Images For Sikuli/ApplyUpdates.png"); 
  	Pattern OkUpdates = new Pattern("C:/Images For Sikuli/OkUpdates.png"); 
  	Pattern OkPrinter = new Pattern("C:/Images For Sikuli/OkPrinter.png"); 
  	Pattern RegionIDClick = new Pattern("C:/Images For Sikuli/RegionIDClick.png"); 
  	Pattern OkCred = new Pattern("C:/Images For Sikuli/CredQST.png"); 
  	Pattern CredQSTold = new Pattern("C:/Images For Sikuli/CredQSTold.png"); 
  	Pattern Password = new Pattern("C:\\Images For Sikuli\\Password.png");
  	Pattern VoidItem = new Pattern("C:\\Images For Sikuli\\VoidItem.png");
  	Pattern Support = new Pattern("C:\\Images For Sikuli\\Support.png");
  
  	
  	
    Screen s;
	public LandingPage(Screen s) {
		// TODO Auto-generated constructor stub
		super();
		this.s =s;
		
	}
	
	@Test(alwaysRun=true)
	public void siKuliTestCase001(ExtentReports extent, ExtentTest testcase) throws FindFailed, InterruptedException, TesseractException, IOException{
		
		
		LandingPage b = new LandingPage(s);
		
		
		testcase=extent.createTest("TC_001:Verify correct region being loaded");
		
		s.doubleClick(BomgarApp.similar((float)0.6));
	     s.wait(BomgarLogin, 300);   
	     s.click(BomgarLogin.similar((float)0.5));
	     s.wait(QSTT2Login, 300); 
	     s.click(QSTT2Login.similar((float)0.6));
	     s.wait(QSTT2Login, 300);           
	     s.doubleClick(QSTT2Login.similar((float)0.6));
	     s.wait(ScreenSharing, 300);   
	     s.doubleClick(ScreenSharing.similar((float)0.6));
	     s.wait(RollbackLightDesktop1, 300);
	     s.doubleClick(RollbackLightDesktop1.similar((float)0.6));
	     s.wait(StoreNumber, 300);           
	     s.type(StoreNumber, "");
	     s.type(StoreNumber, "7000054");
	     testcase.log(Status.PASS, "User able to enter store number" + StoreNumber);
	     s.wait(RegionIDClick, 300);  
	     s.click(RegionIDClick.similar((float)0.5));
	     s.wait(TabPOS, 300);  
	     s.click(TabPOS.similar((float)0.4));
	     s.type(ReleaseID, "36956");
	     testcase.log(Status.PASS, "User able to enter release id" + ReleaseID);
	     s.wait(RollbackApply, 300);
	     s.click(RollbackApply.similar((float)0.6)); 
	     s.wait(OkRollbackQST, 300);  
	     s.click(OkRollbackQST.similar((float)0.6));
	     Thread.sleep(3000);
	     s.wait(Password, 500);
  	     s.type(Password,"78425");
  	     s.wait(OkCred,500);
  	     s.click(OkCred.similar((float)0.6));
  	     s.wait(UpdateQST, 1500);  //FROM HERE
	     s.click(UpdateQST.similar((float)0.9));
	     testcase.log(Status.PASS, "User able to click on red radio button");
	     s.wait(ViewMgrUpdate, 300);  
	     s.click(ViewMgrUpdate.similar((float)0.6)); 
	     s.wait(ApplyUpdates, 300);  
	     s.click(ApplyUpdates.similar((float)0.6));
	     Thread.sleep(4000);
	     s.wait(OkUpdates, 300);  
	     s.click(OkUpdates.similar((float)0.6));
	     Thread.sleep(4000);
	     s.wait(Password, 600);
	     s.type(Password,"78425");
	     s.wait(OkCred,500);
	     s.click(OkCred.similar((float)0.6));
	     s.wait(Functions, 300); 
		    s.click(Functions.similar((float)0.5));
		    testcase.log(Status.PASS, "User able to click Function button");
		    Thread.sleep(3000);
		    s.wait(Support ,400);
		    s.click(Support.similar((float)0.5));
		    testcase.log(Status.PASS, "User able to click Support button");
		    testcase.log(Status.PASS, "The Release ID is being matched as expected");
		    Thread.sleep(4000);
            Rectangle rectangle=new Rectangle();
            rectangle.setBounds(860,625,60,30);
            String imagePath = capture(rectangle).save(System.getProperty("user.dir")+"/Image/", "ReleaseID");
            ITesseract image = new Tesseract();
            image.setDatapath("C:\\Users\\873780\\workspace\\Tim_Hortons_NextGen.zip_expanded\\Tim_Hortons_NextGen\\tessdata");
            String imageText=image.doOCR(new File(imagePath));
            System.out.println(imageText);
            System.out.println(b.readReleaseId());
            String a1=null;
            String a2=null;

            String replaceAll = imageText.replaceAll("\\s","");
            a1 = replaceAll;
            a2 = b.readReleaseId();
            System.out.println(a1);
            System.out.println(a2);


            if(a1.equals(a2)){
            testcase.log(Status.PASS, "The Release ID is being matched as expected");
            System.out.println("***********Scenario02 PASS: Correct release id being loaded ***********");
            }else{
            testcase.log(Status.FAIL, "The Release ID doesn't matched as expected");
            System.out.println("***********Scenario02 FAIL: Incorrect release id being loaded ***********");
			      
		      }
	}
}


