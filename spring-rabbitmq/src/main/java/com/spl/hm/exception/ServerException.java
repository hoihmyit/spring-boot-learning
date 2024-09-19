package com.spl.hm.exception;

public class ServerException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Server failure: %s";

    public ServerException(final String message, final Throwable cause) {
        super(String.format(MESSAGE_FORMAT, message), cause);
    }
}
