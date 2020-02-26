package com.flipkart.apache.camel.processor.initiate.sandbox;

import com.flipkart.apache.camel.model.api.SandboxServerResponse;
import com.flipkart.apache.camel.model.service.InitiateResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ParseResponseCodeProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        SandboxServerResponse serverResponse = (SandboxServerResponse) exchange.getIn().getBody();
        InitiateResponse initiateResponse = new InitiateResponse();
        setFKResponseCode(serverResponse.getResponseCode(), initiateResponse);
        exchange.getIn().setBody(initiateResponse);
    }

    private void setFKResponseCode(String responseCode, InitiateResponse initiateResponse) {
        initiateResponse.setResponseCode(responseCode);
    }
}
