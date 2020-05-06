package com.flipkart.apache.camel.handler;

import com.flipkart.apache.camel.model.service.InitiateRequest;
import com.flipkart.apache.camel.model.service.InitiateResponse;
import com.google.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

public class SandboxPGHandler implements PGHandler {

    @Inject
    private CamelContext camelContext;

    public InitiateResponse initiate(InitiateRequest initiateRequest) {
        ProducerTemplate template = camelContext.createProducerTemplate();
        return (InitiateResponse) template.sendBody("direct:initiateIR", ExchangePattern.InOut, initiateRequest);
    }
}
