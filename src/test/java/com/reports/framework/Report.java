package com.reports.framework;

import com.util.framework.ReadFromProperties;
import org.apache.commons.io.FileUtils;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;


public class Report extends ReadFromProperties{
    static private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    static private DocumentBuilder db = null;
    static private HashMap map = new HashMap<String, String>() ;;
    private static File fso;

    public Report(){
        try{
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("E_ dd_MMM_yyyy HH_mm_ss z");
            String reportName = getFromProperties("ReportPath") + "/Status_Report_" + dateFormat.format(date);
            fso = new File(reportName);
            if (!fso.exists()) {
                fso.mkdir();
                map.put("Report", reportName);
                FileUtils.copyFileToDirectory(new File(getFromProperties("ReportTemplateHtmlPath")), new File((String) map.get("Report")));
            }

        }catch (Exception ex){
            upDateLog("Exception while creating report file. Please check the code and the setup" + "\n" + ex.toString());
        }
    }
    public static void addTest(String TestCaseName){
        try{
            fso = new File((String)map.get("Report") + "/ReportTemplate.html");
            FileWriter fw = new FileWriter(fso, true);
            fw.append("<div id = \"content\" style=\"padding-left:20px; padding-right:20px;padding-top:20px;\">");
            fw.append("<div class=\"container\">");
            fw.append("<table id=\"qa\" class=\"table table-bordered\">");
            fw.append("<tr class=\"header\">");
            fw.append("<tr class=\"header\">");
            fw.append("<td colspan=\"4\">");
            fw.append(TestCaseName);
            fw.append("</td>");
            fw.append("</tr>");
            fw.append("<tr>");
            fw.append("<th>TestStepDescription</th>");
            fw.append("<th>TestStep</th>");
            fw.append("<th>Status</th>");
            fw.append("<th>ScreenShotPath</th>");
            fw.append("</tr>");

            fw.flush();
            fw.close();

        }catch (Exception ex){
            upDateLog("Unable to add Report name. Please check the code" + "\n" + ex.toString());
        }finally {

        }
    }
    public static void addTestStep(String TestStepDescription, String TestStep, String Status, String ScreenShotPath){
        try{
            fso = new File((String)map.get("Report") + "/ReportTemplate.html");
            FileWriter fw = new FileWriter(fso, true);
            fw.append("<tr>");

            fw.append("<td>");
            fw.append(TestStepDescription);
            fw.append("</td>");

            fw.append("<td>");
            fw.append(TestStep);
            fw.append("</td>");

            fw.append("<td id = \"statusQA\">");
            fw.append(Status);
            fw.append("</td>");

            fw.append("<td>");
            fw.append("<a href= " + "'"+ ScreenShotPath + "'" + "" + ">" + "Show Image</a>");
            fw.append("</td>");

            fw.append("</tr>");
            fw.flush();
            fw.close();

        }catch (Exception ex){
            upDateLog("Unable to add Report name. Please check the code" + "\n" + ex.toString());
        }
    }
    public static void closeReport(){
        try{
            fso = new File((String)map.get("Report") + "/ReportTemplate.html");
            FileWriter fw = new FileWriter(fso, true);

            fw.append("</table>");
            fw.append("</div>");
            fw.append("</div>");

            fw.flush();
            fw.close();

        }catch (Exception ex){
            upDateLog("Unable to add Report name. Please check the code" + "\n" + ex.toString());
        }
    }
}
