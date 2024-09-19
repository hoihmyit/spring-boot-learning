package com.spl.hm;

import com.spl.hm.adapter.Adapter;
import com.spl.hm.exception.ClientException;
import com.spl.hm.exception.ServerException;
import com.spl.hm.exception.ShareClientException;
import com.spl.hm.exception.SimpleTimeoutException;
import com.spl.hm.model.Simple;
import com.spl.hm.model.SimpleRequest;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class ClientImpl implements Client {

    private static final String ERROR_FORMAT = "Failed to get results for request: %s";
    private final Adapter adapter;

    public ClientImpl(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Simple findSimpleById(final SimpleRequest simpleRequest, final int queryPriority, final long waitMillis) {
        final CompletableFuture<Simple> responseFuture = adapter.sendRequest(simpleRequest, queryPriority);
        return handleResponseFuture(responseFuture, waitMillis);
    }

    private <T> T handleResponseFuture(final CompletableFuture<T> responseFuture, final long waitMillis) {
        try {
            return responseFuture.get(waitMillis, TimeUnit.MILLISECONDS);
        } catch (final InterruptedException ex) {
            throw new ServerException(String.format(ERROR_FORMAT, "Server call was interrupted"), ex);
        } catch (final TimeoutException ex) {
            throw new SimpleTimeoutException(String.format(ERROR_FORMAT, "timeout when calling server"), ex);
        } catch (final ExecutionException ex) {
            if (ex.getCause() instanceof ServerException) {
                throw new ServerException(String.format(ERROR_FORMAT, ex.getCause().getMessage()), ex);
            } else if (ex.getCause() instanceof ClientException) {
                throw new ClientException(String.format(ERROR_FORMAT, ex.getCause().getMessage()), ((ShareClientException) ex.getCause()).getStatusCode(), ex);
            } else {
                throw new ServerException(String.format(ERROR_FORMAT, ex.getMessage()), ex);
            }
        }
    }
}
