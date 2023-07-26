package org.parmesh.rental.model;

import lombok.*;
import org.parmesh.rental.entity.Tool;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalToolResponse {

    private Tool tools;
    private  int rentalDays;
    private Date checkoutDate;
    private  Date dueDate;
    private  double dailyRentalCharge;
    private  int chargeDays;
    private  double preDiscountCharge;
    private  int discountPercent;
    private  double discountAmount;
    private  double finalCharge;



}
