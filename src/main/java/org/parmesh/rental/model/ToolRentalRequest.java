package org.parmesh.rental.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ToolRentalRequest {
    private String toolCode;
    private int rentalDays;
    private int discountPercentage;
    private Date checkoutDate;


}
