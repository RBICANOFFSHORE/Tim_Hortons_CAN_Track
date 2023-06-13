package com.driver.framework;

import com.setup.framework.WebDriverProvider;
import com.util.framework.ReadFromProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Driver extends ReadFromProperties {
    static String driverName = getFromProperties("Maindriver");
    public static Supplier<WebDriver> customDriver = ()->{
        try{
            if(driverName.contains("chrome")){
                String chromeDriverPathqa = getFromProperties("ChromeDriverPath");
                String chromeDriverPath = getFromProperties("ChromeDriverPath");
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                WebDriver wd = new ChromeDriver();
                wd.manage().window().maximize();
                wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                return wd;

            }else if(driverName.contains("firefox")){
                System.setProperty("webdriver.gecko.driver", getFromProperties("GekoDriverPath"));
                WebDriver wd = new FirefoxDriver();
                wd.manage().window().maximize();
                wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                return wd;
            }else if(driverName.contains("edge")){
                System.setProperty("webdriver.edge.driver", getFromProperties("EdgeDriverPath"));
                WebDriver wd = new EdgeDriver();
                wd.manage().window().maximize();
                wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                return wd;

            }else {
                return null;
            }
        }catch (Exception ex){
            upDateLog("Exception while creating driver. Please check the setup and the code" + "\n" + ex.toString());
            return null;
        }

    };
}
