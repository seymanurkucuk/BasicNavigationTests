package com.cbt.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    public static List<String> convertToString(List<WebElement> webElementList){
        List<String> stringList = new ArrayList<>();

        for(WebElement each : webElementList){
            stringList.add(each.getText());
        }

        return stringList;
    }
}
