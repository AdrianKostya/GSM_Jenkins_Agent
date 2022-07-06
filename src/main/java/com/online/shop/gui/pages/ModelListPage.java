package com.online.shop.gui.pages;

import com.online.shop.gui.services.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModelListPage extends AbstractPage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @FindBy(xpath = "//*[@id='review-body']/div[1]/ul/li[1]/a")
    private WebElement firstModel;

    public ModelListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public PhoneDetailsPage getFirstModel(){
        wait.until(ExpectedConditions.elementToBeClickable(firstModel)).click();
        return new PhoneDetailsPage(driver);
    }

}