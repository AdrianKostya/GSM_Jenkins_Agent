package com.online.shop.gui.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Driver {

    public static WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "/Users/adriankostya/selenium/chromedriver");
        this.driver = new ChromeDriver();
    }

//    @AfterMethod
//    public void afterTest(){
//        driver.quit();
//    }
}
