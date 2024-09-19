package com.spl.hm.async;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.CompletableFuture;

public interface ResponseHandler {

    long millisSinceCreation();

    <T> CompletableFuture<T> getCompletableFuture();

    void onSuccess(ObjectMapper objectMapper, Object responseBody);

    void onError(Throwable cause);
}
