package org.example.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    // We will parse the day from a LocalDate "2025-01-01" and return an int of the day
    public static int parseDayFromDate(LocalDate date) {
        return Integer.parseInt(date.toString().split("-")[2]);
    }

    // Return true if the inputTime is between the firstTime and secondTime given
    public static boolean isBetweenTimes(String firstTime, String secondTime, String inputTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime inputTimeFormatted = LocalTime.parse(inputTime, formatter);
        LocalTime firstTimeFormatted = LocalTime.parse(firstTime, formatter);
        LocalTime secondTimeFormatted = LocalTime.parse(secondTime, formatter);

        return !inputTimeFormatted.isBefore(firstTimeFormatted) && !inputTimeFormatted.isAfter(secondTimeFormatted);
    }
}
