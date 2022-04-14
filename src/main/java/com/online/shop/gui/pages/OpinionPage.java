package com.online.shop.gui.pages;

import com.online.shop.gui.services.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpinionPage extends AbstractPage {

    String myComment = "//ul[@class='uinfo2']//*[text()='%s']/ancestor::div[@class='user-thread']//p";

    public OpinionPage(WebDriver driver) {
        super(driver);
    }

    public String getTxt(String nickname){
       return driver.findElement(By.xpath(String.format(myComment, nickname))).getText();
    }

}
