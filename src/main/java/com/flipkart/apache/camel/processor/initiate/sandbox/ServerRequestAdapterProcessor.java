package com.flipkart.apache.camel.processor.initiate.sandbox;


import com.flipkart.apache.camel.model.api.SandboxServerRequest;
import com.flipkart.apache.camel.model.service.InitiateRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ServerRequestAdapterProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        InitiateRequest initiateRequest = (InitiateRequest) exchange.getIn().getBody();
        SandboxServerRequest serverRequest = new SandboxServerRequest();
        serverRequest.setAmount(initiateRequest.getAmount());
        serverRequest.setTransactionId(initiateRequest.getTransactionId());
        exchange.getIn().setBody(serverRequest);
    }
}
