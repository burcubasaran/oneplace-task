package com.testautomation.task;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Handling calendar ui
 */
public class CalendarUI extends PageObject{

    public CalendarUI (WebDriver driver) {
        super(driver);
    }

    /**
     * Selects May 21st on the calendar
     */
    public void selectDayInCalendar() {

        //Accepts cookies
        WebElement acceptCookiesButton = driver.findElement(By.id("ez-accept-all"));
        acceptCookiesButton.click();
        driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

        //Travel on the calendar until May appears
        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
        {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }

        //Gets days
        List<WebElement> dates= driver.findElements(By.className("day"));
        //Grab common attribute//Put into list and iterate
        int count=driver.findElements(By.className("day")).size();

        //Select 21st of the month
        for(int i=0;i<count;i++)
        {
            String text=driver.findElements(By.className("day")).get(i).getText();
            if(text.equalsIgnoreCase("21"))
            {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }
    }
}