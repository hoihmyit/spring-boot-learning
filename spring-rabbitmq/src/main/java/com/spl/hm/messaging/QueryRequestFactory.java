package com.spl.hm.messaging;

import com.spl.hm.model.SimpleRequest;
import org.springframework.stereotype.Component;

@Component
public class QueryRequestFactory {

    public QueryMessage.Query getQueryRequest(final Object request) {
        QueryMessage.Query requestQuery;
        if (request instanceof SimpleRequest) {
            requestQuery = new SimpleQuery();
        } else {
            throw new IllegalArgumentException("No known query for given request!");
        }

        return requestQuery;
    }
}
