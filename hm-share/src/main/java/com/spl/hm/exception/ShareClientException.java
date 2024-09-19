package com.spl.hm.exception;

import com.spl.hm.constant.StatusCode;

public class ShareClientException extends Exception {

    private final StatusCode statusCode;

    public ShareClientException(final String message, final StatusCode statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }
}
