package org.parmesh.rental.service;

import org.parmesh.rental.entity.RentalCharge;
import org.parmesh.rental.entity.Tool;
import org.parmesh.rental.enums.ErrorEvent;
import org.parmesh.rental.exception.CustomExceptions;
import org.parmesh.rental.model.GetRentalToolResponse;
import org.parmesh.rental.model.ToolRentalRequest;
import org.parmesh.rental.repository.ChargeInterface;
import org.parmesh.rental.repository.RentalChargeRepository;
import org.parmesh.rental.repository.ToolInterface;
import org.parmesh.rental.repository.ToolRepositoryImpl;

import java.util.Calendar;
import java.util.Date;

import static org.parmesh.rental.utils.RentChargeUtil.formatTwoDecimal;
import static org.parmesh.rental.utils.RentChargeUtil.isHoliday;


public class RentalServiceImpl implements RentalService {


    private final ChargeInterface rental;
    private final ToolInterface toolRepo;

    public RentalServiceImpl() {
        this.rental = new RentalChargeRepository();
        this.toolRepo = new ToolRepositoryImpl();
    }

    /**
     *
     * @param rentalRequest
     * @param rentalToolResponse
     * @return
     */
    @Override
    public GetRentalToolResponse getTotalAmount(ToolRentalRequest rentalRequest, GetRentalToolResponse rentalToolResponse) {

        if (ErrorEvent.contains(rentalRequest) != null) {
            throw new CustomExceptions();

        }

        rentalToolResponse.setCheckoutDate(rentalRequest.getCheckoutDate());
        Tool tool = toolRepo.getToolByCode(rentalRequest.getToolCode());
        rentalToolResponse.setTools(tool);
        RentalCharge rentalCharge = rental.getRentalCharge(rentalRequest.getToolCode());
        rentalToolResponse.setDailyRentalCharge(rentalCharge.getDailyCharge());

// Calculate due date based on checkout date and rental days

        Date dueDate = calculateDueDate(rentalRequest.getCheckoutDate(), rentalRequest.getRentalDays());
        rentalToolResponse.setDueDate(dueDate);

        //get Daily Rental Charge

        double dailyCharge = rentalCharge.getDailyCharge();
        rentalToolResponse.setDailyRentalCharge(dailyCharge);

        // Calculate the charge days
        int chargeDays = calculateChargeDays(rentalRequest.getCheckoutDate(), dueDate, rentalCharge);
        rentalToolResponse.setChargeDays(chargeDays);
        //set Discount percentage

        rentalToolResponse.setDiscountPercent(rentalRequest.getDiscountPercentage());


        // Calculate the pre-discount charge
        double preDiscountCharge = calculatePreDiscountCharge(chargeDays, rentalCharge.getDailyCharge());

        rentalToolResponse.setPreDiscountCharge(preDiscountCharge);

        // Calculate the discount amount
        double discountAmount = calculateDiscountAmount(preDiscountCharge, rentalRequest.getDiscountPercentage());
        rentalToolResponse.setDiscountAmount(discountAmount);
        // Calculate the final charge
        double finalCharge = preDiscountCharge - discountAmount;
        rentalToolResponse.setFinalCharge(formatTwoDecimal(finalCharge));

        return rentalToolResponse;
    }

    /**
     *
     * @param preDiscountCharge
     * @param discountPercentage
     * @return
     */
    private double calculateDiscountAmount(double preDiscountCharge, int discountPercentage) {
        return preDiscountCharge * discountPercentage / 100.0;
    }

    private double calculatePreDiscountCharge(int chargeDays, double dailyCharge) {
        return chargeDays * dailyCharge;
    }

    private int calculateChargeDays(Date checkoutDate, Date dueDate, RentalCharge charge) {
        int chargeDays = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkoutDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1); // Start from the day after checkout date

        while (!calendar.getTime().after(dueDate)) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            // Check if the current day is a weekday and there's a weekday charge for the tool
            if ((dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) && charge.isWeekdayChargeable()) {
                chargeDays++;
            }
            // Check if the current day is a weekend day and there's a weekend charge for the tool
            else if ((dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) && charge.isWeekendChargeable()) {
                chargeDays++;
            }
            // Check if the current day is a holiday and there's a holiday charge for the tool
            else if (isHoliday(calendar.getTime()) && charge.isHolidayChargeable()) {
                chargeDays++;
            }

            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return chargeDays;

    }


    private Date calculateDueDate(Date checkoutDate, int rentalDays) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkoutDate);
        calendar.add(Calendar.DAY_OF_MONTH, rentalDays);
        return calendar.getTime();
    }



//    public void printToConsole() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
//        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
//        NumberFormat percentFormatter = NumberFormat.getPercentInstance(Locale.US);
//
//        System.out.println("Tool code: " + toolCode);
//        System.out.println("Tool type: " + toolType);
//        System.out.println("Brand: " + brand);
//        System.out.println("Checkout date: " + dateFormat.format(checkoutDate));
//        System.out.println("Rental days: " + rentalDays);
//        System.out.println("Discount: " + percentFormatter.format(discountPercentage / 100.0));
//        System.out.println("Daily charge: " + currencyFormatter.format(dailyCharge));
//        System.out.println("Charge days: " + chargeDays);
//        System.out.println("Pre-discount charge: " + currencyFormatter.format(preDiscountCharge));
//        System.out.println("Discount amount: " + currencyFormatter.format(discountAmount));
//        System.out.println("Final charge: " + currencyFormatter.format(finalCharge));
//    }


}
