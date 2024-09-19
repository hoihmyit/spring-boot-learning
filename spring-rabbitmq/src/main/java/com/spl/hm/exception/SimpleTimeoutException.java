package com.spl.hm.exception;

public class SimpleTimeoutException extends RuntimeException {

    public SimpleTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}
