package com.util.framework;

import java.io.FileInputStream;
import java.util.Properties;

public class GetTestData extends ReadFromProperties {
    private static Properties prop;
    private static FileInputStream fis=null;

    public GetTestData(){

    }
    public static String getTestData(String Key){
        try{
            fis = new FileInputStream(getFromProperties("TestDataFile"));
            prop = new Properties();
            prop.load(fis);
            return prop.getProperty(Key);

        }catch (Exception ex){
            upDateLog("Exception while reading Test Data Properties file" + "\n" + ex.toString());
            return "";
        }
    }
}
