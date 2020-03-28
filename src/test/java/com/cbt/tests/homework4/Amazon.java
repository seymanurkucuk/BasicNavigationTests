package com.cbt.tests.homework4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Amazon {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void test1(){
        /*
            1. go to https://www.amazon.com
            2. verify that default value of the All departments dropdown is All
            3. verify that options in the All departments dropdown are not sorted alphabetically
         */
        driver.get("https://www.amazon.com");
        Select dropdownAll = new Select(driver.findElement(By.id("searchDropdownBox")));

        String expected = "All";
        String actual = dropdownAll.getFirstSelectedOption().getText();
        System.out.println(dropdownAll.toString());
    }
}
