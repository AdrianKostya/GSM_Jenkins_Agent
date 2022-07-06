package com.online.shop;

import com.online.shop.gui.pages.*;
import com.online.shop.gui.services.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.ParseException;

public class WebTest extends Driver {



    @Test
    public void verifySuccessLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
       // homePage.clickAcceptCokies();
        Assert.assertTrue(homePage.isPageOpened());
        LoginPage loginPage = homePage.getHeader().openLoginForm().correctLogin();
        Assert.assertTrue(loginPage.isLoginSuccesful());
    }




}
