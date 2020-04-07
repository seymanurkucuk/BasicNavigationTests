package com.cbt.tests.homework4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Amazon2 {

    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void cart() throws InterruptedException {
        /*
            1. go to https://amazon.com
            2. search for "wooden spoon"
            3. click search
            4. remember the name and the price of a random result
            5. click on that random result
            6. verify default quantity of items is 1
            7. verify that the name and the price is the same as the one from step 5
            8. verify button "Add to Cart" is visible
         */

        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("wooden spoon");
        WebElement searchButton = driver.findElement(By.className("nav-input"));
        searchButton.click();

        String resultName = "COOKSMARK 5 Piece Bamboo Wood Nonstick Cooking Utensils - Wooden Spoons and Spatula Utensil Set with Multicolored Silicone Handles in Red Yellow Green Orange Blue";
        String resultPrice = "$16.99";

        Thread.sleep(2000);

        WebElement randomResult = driver.findElement(By.xpath("(//*[contains(text(),'COOKSMARK 5 Piece Bamboo Wood Nonstick Cooking Utensils - Wooden Spoons and Spatula Utensil Set with Multicolored Silicone Handles in Red Yellow Green Orange Blue')])[1]"));
        randomResult.click();

        Select quantity = new Select(driver.findElement(By.id("quantity")));
        WebElement defaultQuantity = quantity.getFirstSelectedOption();

        String actualQuantity = defaultQuantity.getText().trim();

        Assert.assertEquals(actualQuantity,"1");

        String actualName = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String actualPrice = driver.findElement(By.xpath("//span[@id='priceblock_saleprice']")).getText();

        Assert.assertEquals(actualName,resultName);
        Assert.assertEquals(actualPrice,resultPrice);

        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));

        Assert.assertTrue(addToCart.isEnabled());

    }

    @Test
    public void prime(){
        /*
            TASK:
                1. go to https://amazon.com
                2. search for "wooden spoon"
                3. click search
                4. remember name first result that has prime label
                5. select Prime checkbox on the left
                6. verify that name first result that has prime label is same as step 4
                7. check the last checkbox under Brand on the left
                8. verify that name first result that has prime label is different
         */

        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("wooden spoon");
        WebElement searchButton = driver.findElement(By.className("nav-input"));
        searchButton.click();

        String productName = "COOKSMARK 5 Piece Bamboo Wood Nonstick Cooking Utensils - Wooden Spoons and Spatula Utensil Set with Multicolored Silicone Handles in Red Yellow Green Orange Blue";

        WebElement primeButton = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]"));
        primeButton.click();


    }
}

