package org.parmesh.rental.repository;

import org.parmesh.rental.entity.RentalCharge;

public interface ChargeInterface {

    RentalCharge getRentalCharge(String toolCode);
}
