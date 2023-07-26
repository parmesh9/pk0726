package org.parmesh.rental.entity;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
public class RentalCharge {

    private String toolType;
    private double dailyCharge;
    private boolean isWeekdayChargeable;
    private boolean isWeekendChargeable;
    private boolean isHolidayChargeable;


}
