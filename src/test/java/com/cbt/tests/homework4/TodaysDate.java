package com.cbt.tests.homework4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class TodaysDate {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void test(){
        /*
            1. go to http://practice.cybertekschool.com/dropdown
            2. verify that dropdowns under Select your date of birth display current year, month, day
         */

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
    }

    @Test
    public void test2(){
        /*
            1. go to http://practice.cybertekschool.com/dropdown
            2. select daysList random year under Select your date of birth
            3. select month January
            4. verify that days dropdown has current number of days
            5. repeat steps 3, 4 for all the months
                NOTE: if you randomly select daysList leap year, verify February has 29 days
         */

        Select yearList = new Select(driver.findElement(By.id("year")));
        Random random = new Random();
        int index = random.nextInt(100);
        yearList.selectByIndex(index);


        Select months = new Select(driver.findElement(By.id("month")));
        months.selectByVisibleText("January");

        Select days = new Select(driver.findElement(By.id("day")));
        List<WebElement> daysList = days.getOptions();
        int expectedDaysNumber = 31;
        int actualDaysNumber = daysList.size();

        Assert.assertEquals(actualDaysNumber,expectedDaysNumber);

        List<WebElement> monthsList = months.getOptions();
        for (int i = 0; i <monthsList.size() ; i++) {
            months.selectByIndex(i);
            days = new Select(driver.findElement(By.id("day")));
            daysList = days.getOptions();

            if(months.getFirstSelectedOption().getText().equalsIgnoreCase("february")){
                int year = Integer.parseInt(yearList.getFirstSelectedOption().getText());

                if(year%4==0){
                    Assert.assertEquals(daysList.size(),29);
                }else{
                    Assert.assertEquals(daysList.size(),28);
                }
            }else{

                switch (months.getFirstSelectedOption().getText()){
                    case "January":
                    case "March":
                    case "May":
                    case "July":
                    case "August":
                    case "October":
                    case "December":
                        Assert.assertEquals(daysList.size(),31);
                        break;
                    case "April":
                    case "June":
                    case "September":
                    case "November":
                        Assert.assertEquals(daysList.size(),30);
                        break;
                }

            }


        }


    }
}
