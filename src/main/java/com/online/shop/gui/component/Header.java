package com.online.shop.gui.component;

import com.online.shop.gui.services.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends AbstractPage {

    @FindBy(id = "login-active")
    private WebElement loginForm;

    @FindBy(xpath = "//*[@class='head-icon icon-signout']")
    private WebElement logOutBtn;

    public Header(WebDriver driver) {
        super(driver);
    }

    public LoginForm openLoginForm(){
        loginForm.click();
        return new LoginForm(driver);
    }

    public void logOut(){
        logOutBtn.click();
    }
}