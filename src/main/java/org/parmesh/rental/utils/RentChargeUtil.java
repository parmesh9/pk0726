package org.parmesh.rental.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

public class RentChargeUtil {


    private static String formatDate(String date) {
        // Format the date as mm/dd/yy
        // Implement your date formatting logic here
        return date;
    }

    private static String formatPercent(double percent) {
        // Format the percentage as XX%
        return percent + "%";
    }

    // Method to check if a given date is a holiday (Independence Day or Labor Day)
    public static boolean isHoliday(Date date) {
        // Implement the logic to check if the given date is a holiday
        // For this demonstration, we'll consider Labor Day and Independence Day as holidays.
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        return (month == Calendar.SEPTEMBER && dayOfMonth == 1 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) // Labor Day
                || (month == Calendar.JULY && (dayOfMonth == 3 || dayOfMonth == 5) && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY); // Independence Day observed
    }


    // Method to adjust the date to the closest weekday if Independence Day falls on a weekend
    public static Date adjustForHoliday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        if (dayOfWeek == Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -1); // Adjust to Friday
        } else if (dayOfWeek == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, 1); // Adjust to Monday
        }

        return calendar.getTime();
    }

    public static double formatTwoDecimal(double value) {
        BigDecimal b = new BigDecimal(value).setScale(2, RoundingMode.HALF_DOWN);
        return b.doubleValue();
    }
}
