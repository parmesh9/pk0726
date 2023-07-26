package org.parmesh.rental.repository;

import org.parmesh.rental.entity.RentalCharge;

import java.util.ArrayList;
import java.util.List;

public class RentalChargeRepository implements ChargeInterface {
    List<RentalCharge> rentalList = new ArrayList<>();


    public RentalChargeRepository() {
        rentalList.add(new RentalCharge("Ladder", 1.99, true, true, false));
        rentalList.add(new RentalCharge("Chainsaw", 1.49, true, false, true));
        rentalList.add(new RentalCharge("Jackhammer", 2.99, true, false, false));

    }



    @Override
    public RentalCharge getRentalCharge(String toolCode) {

        for (RentalCharge r : rentalList) {
            switch (toolCode) {
                case "CHNS":
                    if (r.getToolType().equals("Chainsaw"))
                        return r;
                case "LADW":
                    if (r.getToolType().equals("Ladder"))
                        return r;
                case "JAKD":
                    if (r.getToolType().equals("Jackhammer"))
                        return r;
                case "JAKR":
                    if (r.getToolType().equals("Jackhammer"))
                        return r;

            }

        }
        return null;
    }


}
