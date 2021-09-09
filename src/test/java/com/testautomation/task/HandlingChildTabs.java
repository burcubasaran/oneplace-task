package com.testautomation.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * This class represents the child tabs testing
 */
public class HandlingChildTabs extends PageObject {

    public HandlingChildTabs(WebDriver driver) {
        super(driver);
    }

    public void handlingChildTabs() {

        //Tick Option1 checkbox and get the text of it
        //Find the text field and send the checkbox text
        //Click on Alert button, it opens alert message
        //Get the text from the alert message
        //Extract Option1 (checkbox text) from the message and print it

        WebElement checkbox = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]"));
        WebElement tickCheckBox = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]/input"));
        tickCheckBox.click();
        Assert.assertTrue(tickCheckBox.isSelected(), "Check box is not selected.");
        String checkboxText = checkbox.getText();
        System.out.println("The checkbox text: " + checkboxText);

        WebElement dropdownMenu = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(dropdownMenu);
        dropdownMenu.click();
        dropdown.selectByVisibleText(checkboxText);

        WebElement textField = driver.findElement(By.id("name"));
        textField.sendKeys(checkboxText);
        WebElement alertButton= driver.findElement(By.id("alertbtn"));
        alertButton.click();

        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Alert message is: " + alertMessage);
        driver.switchTo().alert().dismiss();
        String extractedText = alertMessage.split(",")[0].split(" ")[1].trim();
        System.out.println("Extracted text from the alert message: " + extractedText);

        Assert.assertEquals(extractedText,checkboxText);
    }
}
