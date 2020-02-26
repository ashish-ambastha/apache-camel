package com.flipkart.apache.camel.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InitiateRequest {

    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("amount")
    private int amount;
    @JsonProperty("pg_id")
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
