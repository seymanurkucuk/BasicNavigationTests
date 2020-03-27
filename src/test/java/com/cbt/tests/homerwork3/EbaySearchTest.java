package com.cbt.tests.homerwork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbaySearchTest {
    public static void main(String[] args) throws InterruptedException {
        /*
            1. Open browser
            2. Go to https://ebay.com
            3. Search for wooden spoon
            4. Save the total number of results
            5. Click on link All under the categories on the left menu
            6. Verify that number of results is bigger than the number in step 4
            7. Navigate back to previous research results page
            8. Verify that wooden spoon is still displayed in the search box
            9. Navigate back to home page
            10. Verify that search box is blank
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://ebay.com");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("wooden spoon");

       driver.findElement(By.id("gh-btn")).click();

       String totalNumber = driver.findElement(By.xpath("(//span[@class='BOLD'])[14]")).getText().replace(",","");
       int countOne = Integer.parseInt(totalNumber);
       driver.findElement(By.linkText("All")).click();
       Thread.sleep(2000);
       totalNumber = driver.findElement(By.xpath("(//span[@class='BOLD'])[14]")).getText().replace(",","");
       int countTwo = Integer.parseInt(totalNumber);

       if(countTwo>countOne){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL!");
           System.out.println("countTwo = " + countTwo);
           System.out.println("countOne = " + countOne);
       }

       driver.navigate().back();
       Thread.sleep(2000);

       searchBox = driver.findElement(By.id("gh-ac"));
       String expected = "wooden spoon";
       String actual = searchBox.getAttribute("value");
       if(expected.equals(actual)){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL!");
           System.out.println("expected = " + expected);
           System.out.println("actual = " + actual);
       }

        driver.navigate().back();
       Thread.sleep(2000);
        searchBox = driver.findElement(By.id("gh-ac"));

       if(searchBox.getAttribute("value").isEmpty()){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL!");
       }

       driver.quit();

    }
}
