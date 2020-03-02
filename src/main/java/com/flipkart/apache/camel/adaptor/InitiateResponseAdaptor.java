package com.flipkart.apache.camel.adaptor;

import com.flipkart.apache.camel.model.api.InitiateResponse;
import com.flipkart.apache.camel.model.service.InitiateRequest;

public class InitiateResponseAdaptor {

    public static InitiateResponse adaptToApiModel(com.flipkart.apache.camel.model.service.InitiateResponse initiateResponse) {
        InitiateResponse response = new InitiateResponse();
        response.setResponseCode(initiateResponse.getResponseCode());
        response.setResponseStatus(initiateResponse.getResponseStatus());
        response.setTransactionId(initiateResponse.getTransactionId());
        response.setTransactionRefId(initiateResponse.getTransactionRefId());

        return response;
    }
}
