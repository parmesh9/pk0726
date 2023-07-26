package org.parmesh.rental.service;

import org.parmesh.rental.model.GetRentalToolResponse;
import org.parmesh.rental.model.ToolRentalRequest;

public interface RentalService {

    /**
     * 
     * @param rentalRequest
     * @param rentalToolResponse
     * @return
     */
    GetRentalToolResponse getTotalAmount(ToolRentalRequest rentalRequest, GetRentalToolResponse rentalToolResponse);
}
