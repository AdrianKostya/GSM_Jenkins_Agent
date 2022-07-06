package com.online.shop.gui.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class AbstractPage extends Driver{

    public AbstractPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.get("https://www.gsmarena.com/");
    }
}