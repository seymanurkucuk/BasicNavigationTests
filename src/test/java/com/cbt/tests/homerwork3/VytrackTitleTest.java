package com.cbt.tests.homerwork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackTitleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("http://qa1.vytrack.com/user/login");

        WebElement userNameBox = driver.findElement(By.id("prependedInput"));
        userNameBox.sendKeys("user1");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        driver.findElement(By.id("_submit")).click();

        driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).click();

        WebElement myConfiguration = driver.findElement(By.linkText("My Configuration"));
        Thread.sleep(3000);

        myConfiguration.click();

        String expected = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).getText();


        String actual = driver.getTitle();

        if(actual.startsWith(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }


        driver.quit();

    }
}
