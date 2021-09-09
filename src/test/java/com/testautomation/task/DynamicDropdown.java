package com.testautomation.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This class represents the dynamic dropdown testing
 */
public class DynamicDropdown extends PageObject {

    public DynamicDropdown(WebDriver driver) {
        super(driver);
    }

    public void dynamicDropdownHandling() {

        //Use Action class
        //Find the dynamic dropdown
        //Send "tur" and wait to see the related list
        //Select "Turkey" from the list

        Actions action = new Actions(driver);

        driver.findElement(By.id("autocomplete")).sendKeys("tur");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));

        for (WebElement option:options)
        {
            if(option.getText().equalsIgnoreCase("Turkey")) {
                action.moveToElement(option).click().build().perform();
                break;
            }
        }

    }
}
