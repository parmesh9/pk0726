package org.parmesh.rental.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    REQUEST_BODY_VALIDATION("REQUEST_BODY_ERROR", "Request body should not be empty"),
    RENTAL_DAY_COUNT_VALIDATION("RENTAL_DAY_COUNT_ERROR", "Rental day count is not 1 or greater"),
    DISCOUNT_PERCENTAGE_VALIDATION("DISCOUNT_PERCENTAGE_ERROR", "Discount percent is not in the range 0-100"),
    UNKNOWN_ERROR("UNKNOWN_ERROR", "Check Request Body");

    private String errorMessage;
    private String errorCode;

    ErrorCode(String errorMessage, String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }



    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
