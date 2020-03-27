package com.cbt.tests.homework4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class DAYS {
    @Test
    public void test(){
        /*
            1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
            2. Randomly select a checkbox. As soon as you check any day, print the name of the day
                and uncheck immediately.
              After you check and uncheck Friday for the third time, exit the program.
         */
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        List<WebElement> checkButtonsList = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 0; i <checkButtonsList.size()-2 ; i++) {
            Random ran = new Random();
            int index = ran.nextInt(checkButtonsList.size()-2) ;

            checkButtonsList.get(index).click();
            System.out.println(checkButtonsList.get(index));
            checkButtonsList.get(index).click();

            int countFriday =0;
            if (checkButtonsList.get(index).getText().equalsIgnoreCase("friday")){
                countFriday++;
            }

            if(countFriday>3){
                break;
            }
        }

        driver.quit();

    }
}
