package com.pages.framework;

import org.openqa.selenium.By;

public class HomePage implements IPage{

    public static By search = By.xpath("//input[@title='Search']");
    public static By domainstartURL = By.xpath("//input[@id = 'domain-start-url']");
    public static By connect = By.xpath("//button[@id = 'domain-start-button']");
    public static By menu = By.xpath("//a[contains(.,'Menu')]");
    public static By continueTags = By.xpath("//button[contains(.,' Continue ')]");
    public static By clearTags = By.xpath("//div[@class = 'message-list']/descendant::i[1]");

}
