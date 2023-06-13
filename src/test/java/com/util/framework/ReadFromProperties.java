
package com.util.framework;

import com.logfile.framework.CreateLogFile;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadFromProperties extends CreateLogFile {

    private static Properties prop;
    private static FileInputStream fis=null;

    public ReadFromProperties(){

    }
    public static String getFromProperties(String Key){
        try{
            fis = new FileInputStream("src//test//java//com//util//framework//config.properties");
            prop = new Properties();
            prop.load(fis);
            return prop.getProperty(Key);

        }catch (Exception ex){
            upDateLog("Exception while reading properties file" + "\n" + ex.toString());
            return "";
        }
    }
}
