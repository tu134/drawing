package com.company.drawing;

public class Utils {
    public static String Convert(String[] data)
    {
        return String.join(System.lineSeparator(), data) + System.lineSeparator();
    }
}