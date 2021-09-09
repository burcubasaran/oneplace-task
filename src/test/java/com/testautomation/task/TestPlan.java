package com.testautomation.task;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestPlan {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = Utils.buildChromeDriver();
    }

    @Test
    public void testChildTabs() {
        driver.manage().window().setSize(new Dimension(1280, 1024));
        driver.get("http://qaclickacademy.com/practice.php");
        HandlingChildTabs childTabs = new HandlingChildTabs(driver);
        childTabs.handlingChildTabs();
    }

    @Test
    public void testDynamicDropdown() {
        driver.manage().window().setSize(new Dimension(1280, 1024));
        driver.get("http://qaclickacademy.com/practice.php");
        DynamicDropdown childWindow = new DynamicDropdown(driver);
        childWindow.dynamicDropdownHandling();
    }

    @Test
    public void testCalendarUI() {
        driver.manage().window().setSize(new Dimension(1280, 1024));
        driver.get("https://www.path2usa.com/travel-companions");
        CalendarUI calendarUI = new CalendarUI(driver);
        calendarUI.selectDayInCalendar();
    }

    @AfterClass
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
