package com.flipkart.apache.camel.processor.initiate;

import com.flipkart.apache.camel.model.service.InitiateRequest;
import com.flipkart.apache.camel.model.service.InitiateResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.Map;

public class InitiateResponseProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        Map<String, Object> requestResponseMap = (Map<String, Object>) exchange.getIn().getBody();
        InitiateRequest initiateRequest = (InitiateRequest)requestResponseMap.get("REQUEST");
        InitiateResponse initiateResponse = (InitiateResponse) requestResponseMap.get("RESPONSE");
        initiateResponse.setTransactionId(initiateRequest.getTransactionId());
        exchange.getIn().setBody(initiateResponse);
    }
}
