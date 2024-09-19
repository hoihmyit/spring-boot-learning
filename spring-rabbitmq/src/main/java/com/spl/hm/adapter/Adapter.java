package com.spl.hm.adapter;

import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

public interface Adapter {

    <T> CompletableFuture<T> sendRequest(Object request, @NotNull int queryPriority);
}
