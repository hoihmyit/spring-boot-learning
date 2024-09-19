package com.spl.hm.async;

import com.spl.hm.model.SimpleRequest;
import org.springframework.stereotype.Component;

@Component
public class ResponseHandlerFactory {

    public ResponseHandler getResponseHandler(final Object request) {
        ResponseHandler responseHandler;
        if (request instanceof SimpleRequest) {
            responseHandler = new SimpleResponseHandler();
        } else {
            throw new IllegalArgumentException("No known handler for given request!");
        }

        return responseHandler;
    }
}
