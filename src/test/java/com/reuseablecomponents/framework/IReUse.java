package com.reuseablecomponents.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@FunctionalInterface
interface IClick {
    public String click(WebDriver wd, By obj);

}
@FunctionalInterface
interface IEnterData {
    public String enterData(WebDriver wd, By obj, String Data);

}
@FunctionalInterface
interface ISelectByValue {
    public String selectByValue(WebDriver wd, By obj, String Value);

}
@FunctionalInterface
interface ISelectByText {
    public String selectByText(WebDriver wd, By obj, String Text);

}
@FunctionalInterface
interface ISelectByIndex {
    public String selectByIndex(WebDriver wd, By obj, Integer Index);

}
@FunctionalInterface
interface ISubmit {
    public String submit(WebDriver wd, By obj);

}
@FunctionalInterface
interface IGet {
    public String getURL(WebDriver wd, String URL);

}
