package com.spl.hm.constant;

public enum StatusCode {

    /**
     * Use for the general unknown errors.
     */
    UNKNOWN_ERROR,
    /**
     * OK
     */
    OK,
    /**
     * Use for the connection not found error.
     */
    NOT_FOUND,
    /**
     * Use for the response has no data.
     */
    ZERO_RESULTS,
    /**
     * Use for the response with bad request.
     */
    INVALID_REQUEST,
    /**
     * Use for the responses are denied to service. (UnAuthentication, Expire request key...)
     */
    REQUEST_DENIED,
    /**
     * Use for the server error.
     */
    SERVER_ERROR;
}
