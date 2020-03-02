package com.flipkart.apache.camel.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleResponse {

    @JsonProperty("number")
    private int number;
    @JsonProperty("name")
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
