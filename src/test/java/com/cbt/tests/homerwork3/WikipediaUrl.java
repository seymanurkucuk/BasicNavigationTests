package com.cbt.tests.homerwork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaUrl {

    public static void main(String[] args) {

        /*
            1. Go to wikipedia.org
            2. enter search term selenium webdriver
            3. click on search button
            4. click on search result Selenium (software)
            5. verify url ends with Selenium_(software)
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");

        WebElement searchBox= driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium webdriver");

        WebElement clickButton = driver.findElement(By.xpath("html/body/div[2]/form/fieldset/button"));
        clickButton.click();

        WebElement resultSelenium = driver.findElement(By.linkText("Selenium (software)"));
        resultSelenium.click();

        String expected = "Selenium_(software)";

        String actual = driver.getTitle();

        if(actual.endsWith(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL!");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }

        driver.quit();
    }
}
