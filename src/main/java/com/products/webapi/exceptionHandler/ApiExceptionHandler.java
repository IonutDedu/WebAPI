package com.products.webapi.exceptionHandler;

import com.products.webapi.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> apiRequestException(ResourceNotFoundException ex){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
       ApiException apiException = new ApiException(
               ex.getMessage(),
               HttpStatus.BAD_REQUEST,
               ZonedDateTime.now(ZoneId.of("Z"))
       );

       logger.info("HttpStatus: " + badRequest + " " + getClass());
       return new ResponseEntity<>(apiException, badRequest);
    }
}
