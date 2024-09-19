package com.spl.hm.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spl.hm.constant.StatusCode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class ErrorResponse extends BaseResponse {

    private String error;
    private StatusCode statusCode;

    public ErrorResponse() {
        super(false);
        this.error = null;
    }

    public ErrorResponse(String error) {
        super(false);
        this.error = error;
    }

    public ErrorResponse(String error, StatusCode statusCode) {
        super(false);
        this.error = error;
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
