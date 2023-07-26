package org.parmesh.rental.enums;

import java.util.Arrays;

public enum HolidayEnums {
    JULY4TY,
    LABORDAY;

 public static boolean contains(String holidayEvent){
     return Arrays.stream(HolidayEnums.values()).anyMatch(d->d.name().equals(holidayEvent));
 }




}
