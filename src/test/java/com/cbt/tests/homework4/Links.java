package com.cbt.tests.homework4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Links {
    WebDriver driver ;
    @BeforeMethod
    public void beforeMethod(){
        driver = BrowserFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void Links(){
        /*
            1. go to https://www.w3schools.com/
            2. find all the elements in the page with the tag a
            3. for each of those elements, if it is displayed on the page,
               print the text and the href of that element.
         */
        driver.get("https://www.w3schools.com/");

        List<WebElement> tagNameA = driver.findElements(By.tagName("a"));

        int n = 0;
        for(WebElement each : tagNameA){
            if(each.isDisplayed()){
                System.out.println(n+"==>  "+each.getText());
                System.out.println(n+"==>  "+each.getAttribute("href"));

            }
            n++;
        }
    }

    @Test
    public void validLinks(){
        /*
            1. go to https://www.selenium.dev/documentation/en/
            2. find all the elements in the page with the tag a
            3. verify that all the links are valid
         */
        driver.get("https://www.selenium.dev/documentation/en/");

        List<WebElement> tagNameA = driver.findElements(By.tagName("a"));

        List<String> allHref = new ArrayList<>();
        for(WebElement each : tagNameA){
            allHref.add(each.getAttribute("href"));
        }

        Assert.assertTrue(!allHref.equals("null"));
    }
}

