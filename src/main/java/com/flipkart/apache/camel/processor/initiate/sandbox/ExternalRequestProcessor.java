package com.flipkart.apache.camel.processor.initiate.sandbox;

import com.flipkart.apache.camel.external.ExternalClient;
import com.flipkart.apache.camel.model.api.SandboxServerRequest;
import com.flipkart.apache.camel.model.api.SandboxServerResponse;
import com.google.inject.Inject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ExternalRequestProcessor implements Processor {

    private ExternalClient externalClient;

    @Inject
    public ExternalRequestProcessor(ExternalClient externalClient) {
        this.externalClient = externalClient;
    }

    public void process(Exchange exchange) throws Exception {
        SandboxServerRequest serverRequest = (SandboxServerRequest) exchange.getIn().getBody();
        SandboxServerResponse serverResponse = externalClient.getInitiateResponse(serverRequest);
        exchange.getIn().setBody(serverResponse);
    }
}
