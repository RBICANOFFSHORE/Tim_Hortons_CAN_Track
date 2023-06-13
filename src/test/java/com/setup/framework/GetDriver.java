package com.setup.framework;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.logfile.framework.CreateLogFile;
import org.openqa.selenium.WebDriver;

public class GetDriver{
    private static CreateLogFile log = new CreateLogFile();
    private final Provider<IDriver> iwd;
    @Inject
    public GetDriver(Provider<IDriver> wd){
        this.iwd = wd;
    }
    public WebDriver getFinalDriver(){
        try{
            return iwd.get().driver();
        }catch (Exception ex){
            log.upDateLog("Exception while returning Webdriver " + "\n" + ex.toString());
            return null;
        }
    }
}
