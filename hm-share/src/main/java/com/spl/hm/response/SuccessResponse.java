package com.spl.hm.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SuccessResponse<T> extends BaseResponse {

    /**
     * The generic object response for success response.
     */
    private final T data;

    /**
     * SuccessResponse
     *
     * @param data object response
     */
    public SuccessResponse(T data) {
        super(true);
        this.data = data;
    }

    public SuccessResponse() {
        super(false);
        this.data = null;
    }

    public T getData() {
        return data;
    }
}
