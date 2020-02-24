package com.flipkart.apache.camel.processor;

import com.flipkart.apache.camel.model.SampleRequest;
import com.flipkart.apache.camel.model.SampleResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SampleResponseProcessor implements Processor {


    public void process(Exchange exchange) throws Exception {

        SampleResponse sampleResponse = (SampleResponse) exchange.getIn().getBody();
        sampleResponse.setName(sampleResponse.getName());
        sampleResponse.setNumber(sampleResponse.getNumber() + 1);
        exchange.getIn().setBody(sampleResponse);

    }
}
