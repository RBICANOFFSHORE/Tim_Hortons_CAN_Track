package com.setup.framework;

import com.util.framework.ReadFromProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

class ChromeWD extends ReadFromProperties implements IDriver {
    @Override
    public WebDriver driver() {
        String chromeDriverPath = null;
        try{
            String os = System.getProperty("os.name");
            if(os.toLowerCase().contains("mac")){
                chromeDriverPath = getFromProperties("ChromeDriverPathMac");
            }else{
                String chromeDriverPathqa = getFromProperties("ChromeDriverPath");
                chromeDriverPath = getFromProperties("ChromeDriverPath");
            }
            upDateLog("OS Name is : " + os);
            System.out.println(os);
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            WebDriver wd = new ChromeDriver();
            wd.manage().window().maximize();
            wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return wd;
        }catch (Exception ex){
            upDateLog("Exception while returning Chrome Driver" + "\n" + ex.toString());
            return null;
        }
    }
}
class FirefoxWD extends ReadFromProperties implements IDriver {
    @Override
    public WebDriver driver() {
        try{
            System.setProperty("webdriver.gecko.driver", getFromProperties("GekoDriverPath"));
            WebDriver wd = new FirefoxDriver();
            wd.manage().window().maximize();
            wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return wd;
        }catch (Exception ex){
            upDateLog("Exception while creating Geko driver" + "\n" + ex.toString());
            return null;
        }
    }
}
class EdgeWD extends ReadFromProperties implements IDriver {
    @Override
    public WebDriver driver() {
        try{
            System.setProperty("webdriver.edge.driver", getFromProperties("EdgeDriverPath"));
            WebDriver wd = new EdgeDriver();
            wd.manage().window().maximize();
            wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return wd;

        }catch (Exception ex){
            upDateLog("Exception while creating Edge driver" + "\n" + ex.toString());
            return null;
        }

    }
}
class IEWD extends ReadFromProperties implements IDriver {

    @Override
    public WebDriver driver() {
        try{
            System.setProperty("webdriver.ie.driver", getFromProperties("IEDriverPath"));
            WebDriver wd = new InternetExplorerDriver();
            wd.manage().window().maximize();
            wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return wd;
        }catch (Exception ex){
            upDateLog("Exception while returning IE Driver. Please check log" + "\n" + ex.toString());
            return null;
        }
    }
}
class SafariWD implements IDriver {

    @Override
    public WebDriver driver() {
        return null;
    }
}
class AndroidWD implements IDriver {

    @Override
    public WebDriver driver() {
        return null;
    }
}
class IOSWD implements IDriver {

    @Override
    public WebDriver driver() {
        return null;
    }
}

interface IDriver
{
    public WebDriver driver();
}

