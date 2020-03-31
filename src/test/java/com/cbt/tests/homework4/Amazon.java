package com.cbt.tests.homework4;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        //verify that default value of the All departments dropdown is All
        String expected = "All Departments";
        String actual = dropdownAll.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expected);

        //verify that options in the All departments dropdown are not sorted alphabetically
        List<WebElement> listOfAll = dropdownAll.getOptions();

        List<String> expectedListOfExpected= new ArrayList<>();

        for(WebElement each : listOfAll){
            expectedListOfExpected.add(each.getText());
        }

        List<String> actualListOfAll = new ArrayList<>(expectedListOfExpected);

        Collections.sort(actualListOfAll);

        Assert.assertNotEquals(actualListOfAll,expectedListOfExpected);
    }

    @Test
    public void test2(){
        /*
            1. go to https://www.amazon.com/gp/site-directory
            2. verify that every main department name (indicated by blue rectangles in the picture) is
                present in the All departments dropdown (indicated by green rectangle in the picture)
         */
        driver.get("https://www.amazon.com/gp/site-directory");

        List<WebElement> departmentNames = driver.findElements(By.className("fsdDeptTitle"));

        List<String> ListOfDepartmentNames = BrowserUtils.convertToString(departmentNames);
        List<String> LastListofDepartments = new ArrayList<>();
        for(String each : ListOfDepartmentNames){
            String [] arr = each.split(" ");
            LastListofDepartments.add(arr[0]);
        }




        Select dropdownAll = new Select(driver.findElement(By.id("searchDropdownBox")));

        List<WebElement> AllList = dropdownAll.getOptions();
        List <String> ListOfAllDropdown = BrowserUtils.convertToString(AllList);


            Assert.assertFalse(ListOfAllDropdown.containsAll(LastListofDepartments));







    }
}
