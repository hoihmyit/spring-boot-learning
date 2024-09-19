package com.spl.hm.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseResponse {

    /**
     * Returns 'true' if the request completed successfully, otherwise 'false'
     */
    private final boolean success;

    protected BaseResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
