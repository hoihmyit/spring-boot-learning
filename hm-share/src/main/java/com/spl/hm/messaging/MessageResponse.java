package com.spl.hm.messaging;

import com.spl.hm.constant.StatusCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {

    private boolean success;
    private String errorMessage;
    private StatusCode statusCode;
    private String correlationId;
    private Object responseBody;
}
