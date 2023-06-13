package com.setup.framework;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.util.framework.ReadFromProperties;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.URL;


public class TestWD extends ReadFromProperties{

    public static WebDriver getWD(){
        try{
            Injector guice = Guice.createInjector(new GuiceModuleTest());
            GetDriver wd = guice.getInstance(GetDriver.class);
            return wd.getFinalDriver();

        }catch (Exception ex){
            upDateLog("Unable to create WebDriver. Please check the code. This error is coming from TestWD class" +"\n" + ex.toString());
            return null;
        }
    }
    public static void getRestDriver(){
        try{
            RestAssured.baseURI = getFromProperties("BaseURI");

        }catch (Exception ex){
            upDateLog("Exception while creating RestAssured driver." + "\n" + "Please look into API Setup code");
        }
    }
    public static WiniumDriver getWiniumDriver(){
        try{
            DesktopOptions options = new DesktopOptions();
            options.setApplicationPath(getFromProperties("AppPath"));
            WiniumDriver wd = new WiniumDriver(new URL(getFromProperties("WiniumURL")), options);
            return wd;
        }catch (Exception ex){
            upDateLog("Exception while creating Winium driver." + "\n" + "Please look into API Setup code");
            return null;
        }
    }
}
