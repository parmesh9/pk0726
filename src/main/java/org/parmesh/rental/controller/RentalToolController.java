package org.parmesh.rental.controller;

import org.parmesh.rental.enums.ErrorCode;
import org.parmesh.rental.enums.ErrorEvent;
import org.parmesh.rental.exception.CustomExceptions;
import org.parmesh.rental.model.GetRentalToolResponse;
import org.parmesh.rental.model.ToolRentalRequest;
import org.parmesh.rental.service.RentalService;
import org.parmesh.rental.service.RentalServiceImpl;

import java.util.Optional;


public class RentalToolController {

    private final RentalService rentalService;

    public RentalToolController() {
        this.rentalService = new RentalServiceImpl();
    }

    /**
     *
     * @param rentalRequest
     * @return
     * @throws CustomExceptions
     */
    public GetRentalToolResponse checkoutTool(ToolRentalRequest rentalRequest) throws CustomExceptions {

       return Optional.ofNullable(rentalRequest).map(req->rentalService.getTotalAmount(req,new GetRentalToolResponse()))
               .orElseThrow(()->new CustomExceptions(ErrorCode.REQUEST_BODY_VALIDATION, "Check your request body"));

    }
}
