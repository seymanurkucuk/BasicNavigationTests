package com.cbt.tests.homerwork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class GoogleResultsTitle {
    public static void main(String[] args) {

        /*
            1. Open browser
            2. Go to https://google.com
            3. Search for one of the strings the list searchStrs given below
            4. In the results pages, capture the url right above the first result
            5. Click on the first result
            6. Verify that url is equal to the value from step 4
            7. Navigate back
            8. Repeat the same steps for all search items in the list
            Note: Do this exercise using a for loop. Here is the list that was mentioned step 3:
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.google.com/");

        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation" );

        WebElement searchBox = driver.findElement(By.name("q"));

//        for (int i = 0; i <searchStrs.size() ; i++) {
//            searchBox.sendKeys(searchStrs.get(i)+ Keys.ENTER);
//            String expected = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/div/cite")).getText();
//            driver.findElement(By.tagName("a")).click();
//            String actual = driver.getCurrentUrl();
//
//            if(expected.equalsIgnoreCase(actual)){
//                System.out.println("PASS");
//            }else{
//                System.out.println("FAIL");
//                System.out.println("expected = " + expected);
//                System.out.println("actual = " + actual);
//            }
//
//            driver.navigate().back();
//        }


    }
}
