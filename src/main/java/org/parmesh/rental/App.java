package org.parmesh.rental;

import org.parmesh.rental.controller.RentalToolController;
import org.parmesh.rental.model.GetRentalToolResponse;
import org.parmesh.rental.model.ToolRentalRequest;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class App {

    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMAT = NumberFormat.getPercentInstance();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yy");



    public static void main(String[] args) {


        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

        try {

//            Date checoutDate = dateFormat.parse("07/3/23");
//            ToolRentalRequest rentalRequest = new ToolRentalRequest("JAKD", 5, 10, checoutDate);

//            Date checoutDate = dateFormat.parse("07/03/22");
//            ToolRentalRequest rentalRequest = new ToolRentalRequest("CHNS", 6, 0, checoutDate);


            Date checoutDate = dateFormat.parse("9/3/15");
            ToolRentalRequest rentalRequest = new ToolRentalRequest("JAKD", 6, 0, checoutDate);

            RentalToolController rentalToolController = new RentalToolController();
            GetRentalToolResponse rentalToolResponse = rentalToolController.checkoutTool(rentalRequest);

            System.out.println("Tool code: " + rentalToolResponse.getTools().getToolCode());
            System.out.println("Tool type: " + rentalToolResponse.getTools().getToolType());
            System.out.println("Tool brand: " + rentalToolResponse.getTools().getBrand());
            System.out.println("Rental days: " + rentalToolResponse.getRentalDays());
            System.out.println("Check out date: " + DATE_FORMAT.format(rentalToolResponse.getCheckoutDate()));
            System.out.println("Due date: " + DATE_FORMAT.format(rentalToolResponse.getDueDate()));
            System.out.println("Daily rental charge: " + CURRENCY_FORMAT.format(rentalToolResponse.getDailyRentalCharge()));
            System.out.println("Charge days: " + rentalToolResponse.getChargeDays());
            System.out.println("Pre-discount charge: " + CURRENCY_FORMAT.format(rentalToolResponse.getPreDiscountCharge()));
            System.out.println("Discount percent: " + PERCENT_FORMAT.format(rentalToolResponse.getDiscountPercent() / 100.0));
            System.out.println("Discount amount: " + CURRENCY_FORMAT.format(rentalToolResponse.getDiscountAmount()));
            System.out.println("Final charge: " + CURRENCY_FORMAT.format(rentalToolResponse.getFinalCharge()));
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }


    }
}
