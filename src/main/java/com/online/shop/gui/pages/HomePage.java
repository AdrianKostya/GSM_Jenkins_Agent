package com.online.shop.gui.pages;

import com.online.shop.gui.component.Header;
import com.online.shop.gui.services.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @FindBy(xpath = "//*[@class='top-bar clearfix']")
    private Header header;

    @FindBy(className = "review-column-list")
    private WebElement advertismentWindow;

    String brandPhone = "//*[text()='%s']";

    @FindBy(xpath = "//*[@class='flex']//*[text()='Agree and proceed']")
    private WebElement cokieBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        this.header=new Header(driver);
    }

    public boolean isPageOpened(){
        return advertismentWindow.isDisplayed();
    }

    public Header getHeader(){
        return header;
    }

    public void clickAcceptCokies(){
        wait.until(ExpectedConditions.elementToBeClickable(cokieBtn)).click();
    }

    public ModelListPage getBrand(String brand){
        driver.findElement(By.xpath(String.format(brandPhone, brand))).click();
        return new ModelListPage(driver);

    }



}
