package org.parmesh.rental.enums;

import org.parmesh.rental.exception.CustomExceptions;
import org.parmesh.rental.model.ToolRentalRequest;

public class ErrorEvent {


    ErrorEvent() {
    }

    public static CustomExceptions contains(ToolRentalRequest events) {
        if (events.getRentalDays() <= 1) {
            throw  new CustomExceptions(ErrorCode.RENTAL_DAY_COUNT_VALIDATION,"Rental day count is not 1 or greater");
        } else if (events.getDiscountPercentage() < 0 || events.getDiscountPercentage() >100) {
            throw new CustomExceptions(ErrorCode.DISCOUNT_PERCENTAGE_VALIDATION,"Discount percent is not in the range 0-100");
        }
        return null;

    }

}
