package com.cbt.tests.homerwork1_and_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://www.westelm.com", "https://walmart.com");

        String [] titles = new String[urls.size()];
        String [] pageURLS = new String[urls.size()];

        for (int i = 0; i <urls.size() ; i++) {
            driver.get(urls.get(i));
            titles[i]=driver.getTitle().replaceAll(" ","").toLowerCase();
            pageURLS[i]=driver.getCurrentUrl();
            if(pageURLS[i].contains(titles[i])){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL!");
            }
        }

        driver.close();

    }
}
