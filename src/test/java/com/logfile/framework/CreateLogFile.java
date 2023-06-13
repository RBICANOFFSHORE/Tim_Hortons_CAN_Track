// This is a logfile creation class
// This class will create log file in case its not their


package com.logfile.framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateLogFile {
    private final static Logger logger = Logger.getLogger(CreateLogFile.class.getName());
    private final static File file = new File("src//logs.txt");

    public CreateLogFile() {
        try {

//            FileHandler fileHandler = new FileHandler("framework.log", true);
//            logger.addHandler(fileHandler);

        } catch (Exception EX) {
            System.out.println("Exception while creating log file" + "\n"
                    + "Please look into CreateLogFile class inside package com.logfile.framework");

        }
    }

    public static void upDateLog(String message) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));

            FileWriter fileWritter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.append(dtf.format(now) + "     INFO : " + message + "\n");
            bw.close();
        } catch (Exception ex) {
            System.out.println("Exception while updating log file" + "\n" + ex.toString());
        }
    }
}
