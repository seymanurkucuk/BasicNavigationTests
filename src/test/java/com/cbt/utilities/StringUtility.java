package com.cbt.utilities;

public class StringUtility {

    public static void verifyEquals(String expected, String actual){
        if(actual.equalsIgnoreCase(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL!");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
    }
}
