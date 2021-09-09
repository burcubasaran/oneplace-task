package com.testautomation.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Abstract parent class for all page object
 */
public abstract class PageObject {
    // All Test Pages are inheriting from this class

        protected WebDriver driver;

        public PageObject(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

}
