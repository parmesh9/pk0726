package org.parmesh.rental.exception;


import lombok.Getter;
import org.parmesh.rental.enums.ErrorCode;

@Getter
public class CustomExceptions extends RuntimeException {

    private static final long serialVersionUID = -1307493420921168255L;
    private ErrorCode errorCode;
    private String errorMessage;

    public CustomExceptions(ErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        errorMessage = errorMessage;
    }

    public CustomExceptions() {
        super(new CustomExceptions());
    }

    public CustomExceptions(ErrorCode errorCode) {
    }
}
