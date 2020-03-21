package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        String [] titles = new String[3];
        String [] pageURLS = new String[3];
        for (int i = 0; i <urls.size() ; i++) {
            driver.get(urls.get(i));
            titles[i] = driver.getTitle();
            pageURLS[i] = driver.getCurrentUrl();
        }

        for (int i = 0; i <3 ; i++) {
            if(titles[i].equalsIgnoreCase(titles[0])&& pageURLS[i].startsWith("http://practice.cybertekschool.com")){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL!");
            }
        }

        /*
         if(titles[1].equalsIgnoreCase(titles[0]) && titles[1].equalsIgnoreCase(titles[2])){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL!");
        }

        if(pageURLS[0].startsWith("http://practice.cybertekschool.com.") &&
                pageURLS[1].startsWith("http://practice.cybertekschool.com.") &&
                pageURLS[2].startsWith("http://practice.cybertekschool.com. ")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL!");
        }
         */

        driver.close();
    }
}
