package com.util.framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLog implements ILog{

    static ReadFromProperties prop = new ReadFromProperties();
    static File fso;
    static FileWriter fw;

    public CustomLog(){
        try{
            String logPath = prop.getFromProperties("Log");
            fso = new File(logPath+"/"+ "Log.txt");
            if(!fso.exists()){
                fso.createNewFile();
            }
        }catch (Exception ex){
            System.out.println("Exception while creating log file.");
        }
    }
    @Override
    public void uLog(String logText){
        try{
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
            String newDateTime = sdf.format(date);
            fw = new FileWriter(fso, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(newDateTime + " Log Details : " + logText);
            bw.newLine();
            bw.close();

        }catch (Exception ex){
            System.out.println("Exception while creating log");

        }
    }

    public static <T> T withProxy( T target, Class<T> itf){
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[]{itf},
                new ProxyClass(target)
        );
    }
}
