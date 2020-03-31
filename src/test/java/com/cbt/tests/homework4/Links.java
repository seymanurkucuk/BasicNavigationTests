package com.cbt.tests.homework4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void test(){
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
}

