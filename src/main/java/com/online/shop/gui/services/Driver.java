package com.online.shop.gui.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class Driver {

    protected static WebDriver driver;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver", "/Users/adriankostya/selenium/chromedriver");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}