package com.online.shop.gui.pages;

import com.online.shop.gui.services.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhoneDetailsPage extends AbstractPage {

    @FindBy(xpath = "//*[text()='Post your opinion']")
    private WebElement postYourOpinionBtn;

    @FindBy(xpath = "//*[text()='Opinions']")
    private WebElement opinionBtn;

    public PhoneDetailsPage(WebDriver driver) {
        super(driver);
    }

    public LeaveOpinionPage clickOpinionBtn(){
        postYourOpinionBtn.click();
        return new LeaveOpinionPage(driver);
    }

    public OpinionPage getOpinionPage(){
        opinionBtn.click();
        return new OpinionPage(driver);
    }


}