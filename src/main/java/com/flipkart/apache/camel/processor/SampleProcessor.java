package com.flipkart.apache.camel.processor;

import com.flipkart.apache.camel.model.SampleRequest;
import com.flipkart.apache.camel.model.SampleResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SampleProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {

        SampleRequest sampleRequest = (SampleRequest) exchange.getIn().getBody();
        SampleResponse sampleResponse =  new SampleResponse();
        sampleResponse.setName(sampleRequest.getName());
        sampleResponse.setNumber(sampleRequest.getNumber() + 1);
        exchange.getIn().setBody(sampleResponse);

    }
}
