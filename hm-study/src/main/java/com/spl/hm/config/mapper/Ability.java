package com.spl.hm.config.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ability {
    private String innate;
    private List<String> keyQ;
    private List<String> keyW;
    private List<String> keyE;
    private List<String> keyR;

    public String getInnate() {
        return innate;
    }

    public void setInnate(String innate) {
        this.innate = innate;
    }

    public List<String> getKeyQ() {
        return keyQ;
    }

    public void setKeyQ(List<String> keyQ) {
        this.keyQ = keyQ;
    }

    public List<String> getKeyW() {
        return keyW;
    }

    public void setKeyW(List<String> keyW) {
        this.keyW = keyW;
    }

    public List<String> getKeyE() {
        return keyE;
    }

    public void setKeyE(List<String> keyE) {
        this.keyE = keyE;
    }

    public List<String> getKeyR() {
        return keyR;
    }

    public void setKeyR(List<String> keyR) {
        this.keyR = keyR;
    }
}
