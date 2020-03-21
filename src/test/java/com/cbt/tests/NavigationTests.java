package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) throws InterruptedException {
        //test1();
        //test2();
        test3();
    }


    /*
        1. Open Browser
        2. Go	to	website	https://google.com
        3. Save	the	title	in	a	string	variable
        4. Go	to	https://etsy.com
        5. Save	the	title	in	a	string	variable
        6. Navigate	back	to	previous	page
        7. Verify	that	title	is	same is	in	step 3
        8. Navigate	forward	to	previous page
        9. Verify that title is same is in step 5
        10. close the browser
     */

    private static void test3() {
        WebDriver driver = BrowserFactory.getDriver("Edge");
        driver.get("https://google.com");
        String expectedTitleGoogle = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String expectedTitleEtsy = driver.getTitle();

        driver.navigate().back();
        StringUtility.verifyEquals(expectedTitleGoogle,driver.getTitle());

        driver.navigate().forward();
        StringUtility.verifyEquals(expectedTitleEtsy,driver.getTitle());

        driver.close();
    }

    private static void test2() {
        WebDriver driver = BrowserFactory.getDriver("firefox");

        driver.get("https://google.com");
        String expectedTitleGoogle = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String expectedTitleEtsy = driver.getTitle();

        driver.navigate().back();
        StringUtility.verifyEquals(expectedTitleGoogle,driver.getTitle());

        driver.navigate().forward();;
        StringUtility.verifyEquals(expectedTitleEtsy,driver.getTitle());

        driver.close();
    }

    public static void test1() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String expectedTitleGoogle = driver.getTitle();

        driver.navigate().to("https://etsy.com");
        String expectedTitleEtsy = driver.getTitle();

        Thread.sleep(2000);
        driver.navigate().back();
        StringUtility.verifyEquals(expectedTitleGoogle,driver.getTitle());

        Thread.sleep(2000);
        driver.navigate().forward();
        StringUtility.verifyEquals(expectedTitleEtsy,driver.getTitle());

        driver.close();
    }
}
