package com.spl.hm.exception;

import com.spl.hm.constant.StatusCode;

public class ClientException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Client exception: %s, status code: %s";

    private final StatusCode statusCode;

    public ClientException(final String message, final StatusCode statusCode, final Throwable cause) {
        super(String.format(MESSAGE_FORMAT, message, statusCode), cause);
        this.statusCode = statusCode;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }
}
