package cognizant.framework.pageobject;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class appClose {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	Screen s;
	public appClose(Screen s) {
		// TODO Auto-generated constructor stub
		this.s =s;
	}
	
	Pattern BomgarTask = new Pattern("C:\\Images For Sikuli\\BomgarTask.png");
  	Pattern YesRemote = new Pattern("C:\\Images For Sikuli\\YesRemote.png");
  	Pattern Password = new Pattern("C:\\Images For Sikuli\\Password.png");
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
  	Pattern SMCoffee =new Pattern("C:/Images For Sikuli/SMCoffee.png");
  	Pattern MDCoffee = new Pattern("C:/Images For Sikuli/MDCoffee.png");
  	Pattern LGCoffee = new Pattern("C:/Images For Sikuli/LGCoffee.png");
  	Pattern EatIn = new Pattern("C:/Images For Sikuli/EatIn.png"); 
  	Pattern CanOrder = new Pattern("C:/Images For Sikuli/CanOrder.png"); 
  	Pattern CanYes = new Pattern("C:/Images For Sikuli/CanYes.png"); 
  	Pattern Functions = new Pattern("C:/Images For Sikuli/Functions.png"); 
  	Pattern MinPOS = new Pattern("C:/Images For Sikuli/MinPOS.png"); 
  	Pattern MDCoffeeOrder = new Pattern("C:/Images For Sikuli/MDCoffeeOrder.png"); 
  	Pattern ScreenKey = new Pattern("C:/Images For Sikuli/ScreenKey.png"); 
	
  	
  	@Test
	public void appClose(ExtentReports extent, ExtentTest testcase) throws FindFailed, InterruptedException
	  {
  		
  		testcase=extent.createTest("Successfully closed application");
		    Thread.sleep(3000);
		    s.wait(Functions, 300); 
		    s.click(Functions.similar((float)0.5));
		    s.wait(MinPOS, 300);  
		    s.click(MinPOS.similar((float)0.8));
		    s.wait(IQTouchTaskbar, 300);
		    s.rightClick(IQTouchTaskbar.similar((float)0.5));
		    s.wait(CloseWindow, 300);
		    s.click(CloseWindow.similar((float)0.5));
		    s.wait(RollbackLightTaskbar, 300);
		    s.rightClick(RollbackLightTaskbar.similar((float)0.5));
		    s.wait(CloseWindow, 300);
		    s.click(CloseWindow.similar((float)0.5));
		    s.wait(BomgarTask, 300);
		    s.rightClick(BomgarTask.similar((float)0.5));
		    s.wait(CloseWindow, 300);
		    s.click(CloseWindow.similar((float)0.5));
		    s.wait(YesRemote, 300);
		    s.click(YesRemote.similar((float)0.5));
		    s.wait(CloseTerminal, 300);  
		    s.click(CloseTerminal.similar((float)0.6));
		    s.wait(EndSession, 300);
		    s.click(EndSession.similar((float)0.8)); 
		    s.wait(File, 300); 
		    s.click(File.similar((float)0.5)); 
	        s.click(QuitBomgar.similar((float)0.9)); 
		    s.click(YesBomgar.similar((float)0.9)); 
		    extent.flush();
		    System.out.println("flush)");
		   
			 
			 	 
	  }

}
