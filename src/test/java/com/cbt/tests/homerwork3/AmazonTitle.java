package com.cbt.tests.homerwork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTitle {
    public static void main(String[] args) {
        /*
            1. Open go to amazon
            2. enter any search term
            3. click on search button
            4. verify page title contains the search term
            5. close browser
         */
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("pencil");

        WebElement clickButton = driver.findElement(By.className("nav-input"));
        clickButton.click();

        String expected = "pencil";
        String actual = driver.getTitle();

        if(actual.contains(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL!");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }

        driver.close();




    }
}
