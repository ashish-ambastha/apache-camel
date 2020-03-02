package com.flipkart.apache.camel.manager;

import com.flipkart.apache.camel.model.api.SampleRequest;
import com.flipkart.apache.camel.model.api.SampleResponse;
import com.google.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;


public class TestRouteManager {

    private CamelContext camelContext;

    @Inject
    public TestRouteManager(CamelContext camelContext) {
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
