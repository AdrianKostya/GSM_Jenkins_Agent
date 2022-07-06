package com.online.shop.gui.pages;

import com.online.shop.gui.services.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OpinionPage extends AbstractPage {

    String myComment = "//ul[@class='uinfo2']//*[text()='%s']/ancestor::div[@class='user-thread']//p";

    @FindBy(xpath = "//*[@class='upost']")
    private List<WebElement> postedTime;

    public OpinionPage(WebDriver driver) {
        super(driver);
    }

    public String getTxt(String nickname){
        return driver.findElement(By.xpath(String.format(myComment, nickname))).getText();
    }

    public boolean isDateSorted() throws ParseException {
        List<Date> dataColector =  new LinkedList<>();
        SimpleDateFormat completeTimePattert = new SimpleDateFormat("dd MMM yyyy hh:mm:ss aa", Locale.ENGLISH);
        SimpleDateFormat nonCompleteTimePat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        Calendar c = Calendar.getInstance();
        //   convert from WebElement to String List;
        List <String> postedTimeStr = new ArrayList<>();
        for(WebElement eachTime:postedTime) {
            postedTimeStr.add(eachTime.getText());
        }
        //  parse and convert to Date - example( 2 min ago , or 3 hours ago)
        if(!postedTimeStr.isEmpty()) {
            for (String eachTimeStr : postedTimeStr) {
                String splitTime[] = eachTimeStr.split(" ");
                if (splitTime[1].equals("minutes")) {
                    int number = Integer.parseInt(splitTime[0]);
                    c.add(Calendar.MINUTE, -number);
                    Date d = c.getTime();
                    String newStopTime = completeTimePattert.format(d);
                    Date convertedDate = completeTimePattert.parse(newStopTime);
                    dataColector.add(convertedDate);
                    c.add(Calendar.MINUTE, +number);
                }
                if (splitTime[1].equals("hours")) {
                    int number = Integer.parseInt(splitTime[0]);
                    c.add(Calendar.HOUR, -number);
                    Date d = c.getTime();
                    String newStopTime = completeTimePattert.format(d);
                    Date convertedDate = completeTimePattert.parse(newStopTime);
                    dataColector.add(convertedDate);
                    c.add(Calendar.HOUR, +number);
                }
                //parse example (12 Apr 2022)
                if (!splitTime[1].equals("minutes") && !splitTime[1].equals("hours")) {
                    Date convertedDate = nonCompleteTimePat.parse(eachTimeStr);
                    dataColector.add(convertedDate);
                }
            }
            //check if collected date is sorted
            Date actualTime = new Date();
            actualTime.getTime();
            for (Date timeInPast : dataColector) {
                System.out.println(timeInPast);
                for (int i = 1; i <= 1; i++) {
                    if (timeInPast.after(actualTime)) {
                        return false;
                    }
                    actualTime = timeInPast;
                }
            }
            return true;
        }
        return false;
    }

}