package com.spl.hm.async;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spl.hm.model.Simple;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SimpleResponseHandler implements ResponseHandler {

    private final long creationNS;
    private final CompletableFuture<List<Simple>> simplesFuture;

    public SimpleResponseHandler() {
        creationNS = System.nanoTime();
        simplesFuture = new CompletableFuture<>();
    }

    @Override
    public long millisSinceCreation() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - creationNS);
    }

    @Override
    public void onSuccess(final ObjectMapper objectMapper, final Object responseBody) {
        final List<Simple> simples = objectMapper.convertValue(responseBody, new TypeReference<List<Simple>>() {
        });
        simplesFuture.complete(simples);
    }

    @Override
    public CompletableFuture<List<Simple>> getCompletableFuture() {
        return simplesFuture;
    }

    @Override
    public void onError(final Throwable cause) {
        simplesFuture.completeExceptionally(cause);
    }
}
