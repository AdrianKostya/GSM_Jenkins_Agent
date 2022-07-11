package com.online.shop;

import com.online.shop.gui.pages.*;
import com.online.shop.gui.services.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.text.ParseException;

public class WebTest extends Driver {

    @Test
    public void verifyWrongLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        //homePage.clickAcceptCokies();
        Assert.assertTrue(homePage.isPageOpened());
        LoginPage loginPage = homePage.getHeader().openLoginForm().wrongLogin();
        Assert.assertTrue(loginPage.isLoginFailed());

    }

    @Test
    public void verifySuccessLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        //homePage.clickAcceptCokies();
        Assert.assertTrue(homePage.isPageOpened());
        LoginPage loginPage = homePage.getHeader().openLoginForm().correctLogin();
        Assert.assertTrue(loginPage.isLoginSuccesful());
    }

//    @Test
//    public void verifyCommentPosted(){
//        String nickname = "Bruno22";
//        String commentTxt = "Like design";
//        String brand ="Samsung";
//        HomePage homePage = new HomePage(driver);
//        homePage.open();
//        Assert.assertTrue(homePage.isPageOpened());
//        //homePage.clickAcceptCokies();
//        homePage.getHeader().openLoginForm().correctLogin();
//        ModelListPage modelListPage = homePage.getBrand(brand);
//        LeaveOpinionPage leaveOpinionPage = modelListPage.getFirstModel().clickOpinionBtn();
//        leaveOpinionPage.setComment(commentTxt);
//        Assert.assertTrue(leaveOpinionPage.isSuccessfulPostedMsgPresent());
//        homePage.getHeader().logOut();
//        //Here i log again
//        homePage.getHeader().openLoginForm().correctLogin();
//        modelListPage = homePage.getBrand(brand);
//        OpinionPage opinionPage =modelListPage.getFirstModel().getOpinionPage();
//        String postedComment = opinionPage.getTxt(nickname);
//        Assert.assertEquals(postedComment, commentTxt);
//    }

    @Test
    public void getData() throws ParseException {
      HomePage homePage = new HomePage(driver);
      homePage.open();
      //homePage.clickAcceptCokies();

      ModelListPage modelListPage = homePage.getBrand("Apple");
      Assert.assertTrue(modelListPage.getFirstModel().getOpinionPage().isDateSorted());
    }


}
