package org.example.utils;

public class MoneyProcessingUtil {

    // Takes in a double returns you how many cents Ex. Input = 12.99, Output = 99
    public static int getCents(double money) {
        return Integer.parseInt(Double.toString(money).split("\\.")[1]);
    }
}
