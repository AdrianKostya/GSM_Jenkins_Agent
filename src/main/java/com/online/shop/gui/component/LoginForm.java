package com.online.shop.gui.component;

import com.online.shop.gui.pages.HomePage;
import com.online.shop.gui.pages.LoginPage;
import com.online.shop.gui.services.AbstractPage;
import com.online.shop.gui.services.UserService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractPage {

    UserService userService = new UserService();
    User user = userService.setUserData();

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "upass")
    private WebElement passwordField;

    @FindBy(id = "nick-submit")
    private WebElement submitBtn;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public LoginPage wrongLogin(){
        emailField.sendKeys("s9r@mail.ru");
        passwordField.sendKeys(user.getPassword());
        submitBtn.click();
        return new LoginPage(driver);
    }

    public LoginPage correctLogin(){
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        submitBtn.click();
        return new LoginPage(driver);
    }

}