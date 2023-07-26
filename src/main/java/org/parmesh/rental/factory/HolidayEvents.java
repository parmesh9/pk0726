//package org.parmesh.rental.factory;
//
//import org.parmesh.rental.enums.HolidayEnums;
//import org.parmesh.rental.model.ToolRentalRequest;
//
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.util.*;
//
//public class HolidayEvents {
//
//    private ToolRentalRequest toolRentalRequest;
//
//    public HolidayEvents(ToolRentalRequest toolRentalRequest) {
//        this.toolRentalRequest = toolRentalRequest;
//    }
//
//
////check holiday
//
//
//    private final Map<HolidayEnums, String> holiday = new EnumMap<>(HolidayEnums.class);
//
//    public static boolean isHoliday(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//
//        return ((month == Calendar.JULY && day == 4) ||
//                (month == Calendar.SEPTEMBER && dayOfWeek == Calendar.MONDAY && day >= 1 && day <= 7));
//    }
//
//    private Map<HolidayEnums, String> getJuly4ThDay(HolidayEnums e) {
//
//        for (int i = 0; i < toolRentalRequest.getRentalDays(); i++) {
//            DayOfWeek nextDay = toolRentalRequest.getCheckoutDate().plusDays(i).getDayOfWeek();
//            if (nextDay == DayOfWeek.SATURDAY) {
//                holiday.put(HolidayEnums.JULY4TY, "MONDAY");
//
//            } else if (nextDay == DayOfWeek.SUNDAY) {
//                holiday.put(HolidayEnums.JULY4TY, "MONDAY");
//            }
//
//
//        }
//        return holiday;
//    }
//
//
//    public static HolidayEnums getHolidayType(LocalDate date) {
//        if (date.getMonthValue() == 7 && date.getDayOfMonth() == 4) {
//            return HolidayEnums.JULY4TY;
//        } else {
//            if (date.getMonthValue() == 9 && date.getDayOfWeek() == DayOfWeek.MONDAY && date.getDayOfMonth() <= 7) {
//                return HolidayEnums.LABORDAY;
//
//            }
//        }
//
//        return null;
//    }
//
//    private Map<HolidayEnums, String> getLaborDay(HolidayEnums e) {
//        if (e.equals(HolidayEnums.LABORDAY)) {
//            holiday.put(HolidayEnums.LABORDAY, "MONDAY");
//
//
//        }
//        return holiday;
//    }
//
//
//}
