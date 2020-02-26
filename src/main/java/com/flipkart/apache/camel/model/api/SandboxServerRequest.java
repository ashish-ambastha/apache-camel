package com.flipkart.apache.camel.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SandboxServerRequest {

    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("amount")
    private int amount;

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

    @Override
    public String toString() {
        return "SandboxServerRequest{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
