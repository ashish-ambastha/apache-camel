package com.flipkart.apache.camel.adaptor;

import com.flipkart.apache.camel.model.service.InitiateRequest;

public class InitiateRequestAdaptor {

    public static InitiateRequest adaptToServiceModel(com.flipkart.apache.camel.model.api.InitiateRequest initiateRequest) {
        InitiateRequest request = new InitiateRequest();
        request.setAmount(initiateRequest.getAmount());
        request.setPgId(initiateRequest.getPgId());
        request.setTransactionId(initiateRequest.getTransactionId());

        return request;
    }
}
