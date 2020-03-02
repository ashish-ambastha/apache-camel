package com.flipkart.apache.camel.processor.initiate.sandbox;

import com.flipkart.apache.camel.model.api.SandboxServerResponse;
import com.flipkart.apache.camel.model.service.InitiateResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ParseResponseProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        SandboxServerResponse serverResponse = (SandboxServerResponse) exchange.getIn().getBody();
        InitiateResponse initiateResponse = new InitiateResponse();
        setFKResponseCode(serverResponse, initiateResponse);
        exchange.getIn().setBody(initiateResponse);
    }

    private void setFKResponseCode(SandboxServerResponse serverResponse, InitiateResponse initiateResponse) {
        initiateResponse.setResponseCode(serverResponse.getResponseCode());
        initiateResponse.setResponseStatus(serverResponse.getResponseStatus());
        initiateResponse.setTransactionId(serverResponse.getTransactionId());
        initiateResponse.setTransactionRefId(serverResponse.getTransactionRefId());
    }
}
