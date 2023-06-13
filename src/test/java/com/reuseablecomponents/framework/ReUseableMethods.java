package com.reuseablecomponents.framework;

import com.util.framework.ReadFromProperties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ReUseableMethods extends ReadFromProperties implements IClick, ISelectByIndex, IEnterData, ISelectByText, ISelectByValue, ISubmit, IGet {
    private static WebDriver wd;
    public ReUseableMethods(WebDriver wd){
        this.wd = wd;
    }

    @Override
    public String click(WebDriver wd, By obj) {
        try{
            webdriverWait(wd, obj);
            wd.findElement(obj).click();
            return "Pass";

        }catch (Exception ex){
            upDateLog("Unable to click on element." + "\n" + ex.toString());
            return "Fail";
        }
    }

    @Override
    public String enterData(WebDriver wd, By obj, String Data) {
        try{
            webdriverWait(wd, obj);
            wd.findElement(obj).sendKeys(Data);
            return "Pass";

        }catch (Exception ex){
            upDateLog("Unable to enter data on element." + "\n" + ex.toString());
            return "Fail";
        }
    }

    @Override
    public String selectByValue(WebDriver wd, By obj, String value) {
        try{
            webdriverWait(wd, obj);
            Select select = new Select(wd.findElement(obj));
            select.selectByValue(value);
            return "Pass";

        }catch (Exception ex){
            upDateLog("Unable to select by value." + "\n" + ex.toString());
            return "Fail";
        }
    }

    @Override
    public String selectByText(WebDriver wd, By obj, String Text) {
        try{
            webdriverWait(wd, obj);
            Select select = new Select(wd.findElement(obj));
            select.selectByVisibleText(Text);
            return "Pass";

        }catch (Exception ex){
            upDateLog("Unable to select by text." + "\n" + ex.toString());
            return "Fail";
        }
    }

    @Override
    public String selectByIndex(WebDriver wd, By obj, Integer Index) {
        try{
            webdriverWait(wd, obj);
            Select select = new Select(wd.findElement(obj));
            select.selectByIndex(Index);
            return "Pass";

        }catch (Exception ex){
            upDateLog("Unable to select by Index." + "\n" + ex.toString());
            return "Fail";
        }
    }

    @Override
    public String submit(WebDriver wd, By obj) {
        try{
            webdriverWait(wd, obj);
            wd.findElement(obj).submit();
            return "Pass";

        }catch (Exception ex){
            upDateLog("Unable to submit." + "\n" + ex.toString());
            return "Fail";
        }
    }

    @Override
    public String getURL(WebDriver wd, String URL) {
        try{
            wd.get(URL);
            return "Pass";

        }catch (Exception ex){
            upDateLog("Unable to get URL." + "\n" + ex.toString());
            return "Fail";
        }
    }

    public String customWait(Integer waitTime){
        try{
            Thread.sleep(waitTime*1000);
            return "Pass";

        }catch (Exception ex){
            upDateLog("Unable to wait for " + waitTime + " mili seconds" + "\n" + ex.toString());
            return "Fail";
        }

    }

    public static String windowHandleChild(WebDriver wd, String parent){
        try{
            Set<String> allWindows = wd.getWindowHandles();
            for(String childWindow : allWindows){
                if(!childWindow.equalsIgnoreCase(parent)){
                    wd.switchTo().window(childWindow);
                }
            }
            return "Pass";
        }catch (Exception ex){
            upDateLog("Exception occured while working on different window." + "\n" + ex.toString());
            return "Fail";
        }
    }
    public static String windowHandleParent(WebDriver wd, String parent){
        try{
            wd.switchTo().window(parent);
            return "Pass";
        }catch (Exception ex){
            upDateLog("Exception occured while working on different window." + "\n" + ex.toString());
            return "Fail";
        }
    }

    public static String waitCustom(WebDriver wd, By element){
        try{
            for (int i=0; i<=50; i++){
                if(wd.findElements(element).size()>0){
                    System.out.println(i);
                    return "Pass";
                }else {
                    Thread.sleep(i*1000);
                }
            }
            return "Fail";
        }catch (Exception ex){
            upDateLog("Exception happened while working on waitPredicate." + "\n" + ex.toString());
            return "Fail";

        }
    }
    public static String takeScreenShot(WebDriver wd, String name){
        try{
            int num = ThreadLocalRandom.current().nextInt();
            File DestFile = new File(getFromProperties("ReportPath") + "/ScreenShots");
            if(!DestFile.exists()){
                DestFile.mkdir();
            }
            File destFileNew = new File(DestFile + "/"+ name + num + ".png");
            TakesScreenshot src = (TakesScreenshot) wd;
            File SrcFile=src.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(SrcFile, destFileNew);
            return destFileNew.getAbsolutePath().toString();

        }catch (Exception ex){
            upDateLog("Exception taking screen shot");
            return null;
        }
    }
    public String clear(WebDriver wd, By element){
        try{
            webdriverWait(wd, element);
            wd.findElement(element).clear();
            return "Pass";

        }catch (Exception ex){
            upDateLog("Unable to clear value using method clear" + "\n" + ex.toString());
            return "Fail";
        }

    }
    public void webdriverWait(WebDriver wd, By element){
        try{
            customWait(1);
            WebDriverWait wait = new WebDriverWait(wd, 10);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
        }catch (Exception Ex){
            upDateLog("Exception in webdriverWait" + Ex.toString());
        }
    }
    public void switchToForm(WebDriver wd, By element){
        try{
            webdriverWait(wd, element);
            wd.switchTo().frame(wd.findElement(element));
        }catch (Exception Ex){
            upDateLog("Exception in webdriverWait" + Ex.toString());
        }
    }
    public void jsExecutor(WebDriver wd, By element){
        try{
            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("arguments[0].click();", wd.findElement(element));
        }catch (Exception Ex){
            upDateLog("Exception in Javascript Executor" + Ex.toString());
        }
    }
    public void jsExecutorScrolll(WebDriver wd, By element){
        try{
            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("arguments[0].scrollIntoView(true);", wd.findElement(element));
        }catch (Exception Ex){
            upDateLog("Exception in Javascript Executor" + Ex.toString());
        }
    }
}
