package com.flipkart.apache.camel.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InitiateResponse {

    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("response_code")
    private String responseCode;
    @JsonProperty("response_status")
    private String responseStatus;
    @JsonProperty("transaction_ref_id")
    private String transactionRefId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getTransactionRefId() {
        return transactionRefId;
    }

    public void setTransactionRefId(String transactionRefId) {
        this.transactionRefId = transactionRefId;
    }
}
