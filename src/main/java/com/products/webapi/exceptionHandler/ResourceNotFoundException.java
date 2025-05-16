package com.products.webapi.exceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceNotFoundException extends RuntimeException{

    private static final Logger logger = LoggerFactory.getLogger(ResourceNotFoundException.class);

    public ResourceNotFoundException(String message) {
        super(message);
        logger.error("Exception at " + getClass() + " with message: " + message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        logger.error("Exception at " + getClass() + " with message: " + message + " | cause: " + getCause());
    }
}
