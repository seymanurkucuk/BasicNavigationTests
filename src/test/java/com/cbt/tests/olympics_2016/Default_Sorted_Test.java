package com.cbt.tests.olympics_2016;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class Default_Sorted_Test {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver= BrowserFactory.getDriver("chrome");

    }

    @Test
    public void test(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table.");

        //2. Verify that by default the Medal table is sorted by rank. T
        List<WebElement> ranks = driver.findElements(By.xpath("//table[@style='text-align:center']//tbody//tr//td[1]"));

        List<String> stringList = BrowserUtils.convertToString(ranks);
        stringList.remove(10);
        stringList.remove(10);

        List<Integer> actualRanks = new ArrayList<>();

        for (String each: stringList) {
            actualRanks.add(Integer.parseInt(each));
        }

        List<Integer> expectedRanks = new ArrayList<>();
        for(int each: actualRanks){
            expectedRanks.add(each);
        }

        Collections.sort(expectedRanks);
        // verify step 2
        Assert.assertEquals(actualRanks,expectedRanks);

        driver.findElement(By.xpath("//table[@style='text-align:center']//thead/tr/th[2]")).click();

        // 4. Now verify that the table is now sorted by the country names.
        List<WebElement> countries = driver.findElements(By.xpath("//table[@style='text-align:center']//tbody/tr/th"));
        List<String> actualConutryNames = BrowserUtils.convertToString(countries);
        actualConutryNames.remove("Remaining NOCs");
        List<String> expectedCountryNames = new ArrayList<>();

        for(String each :actualConutryNames){
            expectedCountryNames.add(each);
        }

        Collections.sort(expectedCountryNames);
        // verify step 4
        System.out.println("actualConutryNames = " + actualConutryNames);
        System.out.println("expectedCountryNames = " + expectedCountryNames);
        Assert.assertEquals(actualConutryNames,expectedCountryNames);

        // 5. Verify that Rank column is not in ascending order anymore.
        ranks = driver.findElements(By.xpath("//table[@style='text-align:center']//tbody//tr//td[1]"));
        stringList = BrowserUtils.convertToString(ranks);
        stringList.remove("11–86");

        actualRanks = new ArrayList<>();
        for (String each: stringList) {
            actualRanks.add(Integer.parseInt(each));
        }

        expectedRanks = new ArrayList<>();
        for(int each: actualRanks){
            expectedRanks.add(each);
        }
        Collections.sort(expectedRanks);

        System.out.println(actualRanks.toString());
        System.out.println(expectedRanks.toString());
        Assert.assertNotEquals(actualRanks,expectedRanks);


    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
