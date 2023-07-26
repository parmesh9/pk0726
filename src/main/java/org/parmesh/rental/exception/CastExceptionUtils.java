package org.parmesh.rental.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.parmesh.rental.enums.ErrorCode;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CastExceptionUtils {
private static final CustomExceptions ex = new CustomExceptions(ErrorCode.UNKNOWN_ERROR);
private static final Map<String, CustomExceptions> exMap= new HashMap<>();
static{
    exMap.put(ErrorCode.REQUEST_BODY_VALIDATION.getErrorCode(), new CustomExceptions(ErrorCode.REQUEST_BODY_VALIDATION));
}

}
