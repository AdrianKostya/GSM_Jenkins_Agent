package com.online.shop.gui.pages;

import com.online.shop.gui.services.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeaveOpinionPage extends AbstractPage {

    @FindBy(id = "uname")
    private WebElement nickNameField;

    @FindBy(xpath = "//*[@id='ucomment']")
    private WebElement commentField;

    @FindBy(xpath = "//*[@class='button float-right']")
    private WebElement postCommentBtn;

    @FindBy(xpath = "//*[text()='Your opinion was posted. Thank you.']")
    private WebElement opinionPostedTxt;

    public LeaveOpinionPage(WebDriver driver) {
        super(driver);
    }

    public void setComment(String msg){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(commentField)).sendKeys(msg);
        postCommentBtn.click();
    }

    public void setCommentFields(String nickName, String msg){
        nickNameField.sendKeys(nickName);
        commentField.sendKeys(msg);
        postCommentBtn.click();
    }

    public boolean isSuccessfulPostedMsgPresent(){
        return opinionPostedTxt.isDisplayed();
    }





}
