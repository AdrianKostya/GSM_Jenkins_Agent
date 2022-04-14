package com.online.shop.gui.pages;

import com.online.shop.gui.services.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

@FindBy(xpath = "//*[text()='Reason: User record not found.']")
private WebElement loginFaidelTxt;

@FindBy(xpath = "//*[text()='Login successful.']")
private WebElement loginSucccesfulTxt;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginFailed(){
        return loginFaidelTxt.isDisplayed();
    }

    public boolean isLoginSuccesful(){
       return loginSucccesfulTxt.isDisplayed();
    }


}
