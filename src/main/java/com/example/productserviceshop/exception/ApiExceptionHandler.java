package com.example.productserviceshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZoneId;
import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<Object> handleApiRequestException(RequestException e) {
        // Create payload
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        //
        return new ResponseEntity<>(apiException, badRequest);
    }
}
