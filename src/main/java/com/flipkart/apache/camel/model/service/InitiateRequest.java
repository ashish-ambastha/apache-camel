package com.flipkart.apache.camel.model.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InitiateRequest {

    private String transactionId;
    private int amount;
    private String pgId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPgId() {
        return pgId;
    }

    public void setPgId(String pgId) {
        this.pgId = pgId;
    }
}
