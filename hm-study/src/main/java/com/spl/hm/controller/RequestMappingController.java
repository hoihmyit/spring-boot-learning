package com.spl.hm.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class RequestMappingController {

    @RequestMapping(value = "/example/request", method = RequestMethod.GET)
    @ResponseBody
    public String getResponseBySimplePath() {
        return "Get response by simple path!";
    }

    @RequestMapping(value = "/example/request", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public String getResponseAsJsonFromBrowser() {
        return "Get some response with Header Old!";
    }

    @RequestMapping(value = "/example/request/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getResponseBySimplePathWithPathVariable(
            @PathVariable("id") long id) {
        return "Get a specific response with id=" + id;
    }

    @RequestMapping(value = "/example/request/{id}/bar/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String getResponseBySimplePathWithPathVariables(
            @PathVariable long id,
            @PathVariable String name) {
        return "Get response with id=" + name + " from id=" + id;
    }

    @RequestMapping(value = "/example/name", method = RequestMethod.GET)
    @ResponseBody
    public String getNameBySimplePathWithRequestParam(
            @RequestParam("id") long id) {
        return "Get a specific name with id=" + id;
    }
}
