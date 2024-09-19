package com.spl.hm.controller;

import com.spl.hm.Client;
import com.spl.hm.model.Simple;
import com.spl.hm.model.SimpleRequest;
import com.spl.hm.response.SuccessResponse;
import com.spl.hm.util.Timer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"v1/simple"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class SimpleController {

    private final Client client;

    public SimpleController(Client client) {
        this.client = client;
    }

    @GetMapping(value = "/{simpleId}")
    public SuccessResponse<Simple> getSimple(@PathVariable("simpleId") String simpleId) {
        final Timer timer = Timer.start();

        final SimpleRequest simpleRequest = buildSimpleRequest(simpleId);

        return new SuccessResponse<>(client.findSimpleById(simpleRequest, 1, timer.getElapsedMS()));
    }

    private SimpleRequest buildSimpleRequest(final String simpleId) {
        final SimpleRequest simpleRequest = new SimpleRequest();
        simpleRequest.setId(simpleId);
        return simpleRequest;
    }
}
