package com.setup.framework;

import com.google.inject.Provider;
import com.util.framework.ReadFromProperties;

public class WebDriverProvider extends ReadFromProperties implements Provider<IDriver> {

    @Override
    public IDriver get() {
        String driverName = getFromProperties("Maindriver");

        if(driverName.contains("Chrome")){
            upDateLog("Chrome Driver Returned");
            return new ChromeWD();
        }else if (driverName.contains("Firefox")){
            upDateLog("Firefox Driver Returned");
            return new FirefoxWD();
        }else if(driverName.contains("Edge")){
            upDateLog("Edge Driver Returned");
            return new EdgeWD();
        }else {
            return null;
        }
    }
}
