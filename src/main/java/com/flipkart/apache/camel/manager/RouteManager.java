package com.flipkart.apache.camel.manager;

import com.flipkart.apache.camel.model.SampleRequest;
import com.flipkart.apache.camel.model.SampleResponse;
import com.google.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;


public class RouteManager {

    private CamelContext camelContext;

    @Inject
    public RouteManager(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public SampleResponse getSampleResponse(SampleRequest sampleRequest) throws Exception {
        ProducerTemplate template = camelContext.createProducerTemplate();
        return (SampleResponse) template.sendBody("direct:GetData", ExchangePattern.InOut, sampleRequest);
    }

    public SampleResponse getMultiProcessorSampleResponse(SampleRequest sampleRequest) {
        ProducerTemplate template = camelContext.createProducerTemplate();
        return (SampleResponse) template.sendBody("direct:GetMPData", ExchangePattern.InOut, sampleRequest);
    }
}
