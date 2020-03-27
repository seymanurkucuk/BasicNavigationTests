package com.cbt.tests.homework4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class TodaysDate {
    @Test
    public static void test(){
        /*
            1. go to http://practice.cybertekschool.com/dropdown
            2. verify that dropdowns under Select your date of birth display current year, month, day
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        String expectedYear = LocalDate.now().getYear() +"";
        String expectedMouth = LocalDate.now().getMonth().name();
        String expectedDay = LocalDate.now().getDayOfMonth()+"";

        Select yearsList = new Select(driver.findElement(By.id("year")));
        String actualYear = yearsList.getFirstSelectedOption().getText();

        Select monthsList = new Select(driver.findElement(By.id("month")));
        String actualMonth = monthsList.getFirstSelectedOption().getText();

        Select daysList = new Select(driver.findElement(By.id("day")));
        String actualDay = daysList.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualMonth.toLowerCase(),expectedMouth.toLowerCase());
        Assert.assertEquals(actualDay,expectedDay);

        driver.quit();


    }
}
