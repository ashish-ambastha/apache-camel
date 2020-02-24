package com.flipkart.apache.camel.router;

import com.flipkart.apache.camel.model.SampleRequest;
import com.flipkart.apache.camel.model.SampleResponse;
import com.flipkart.apache.camel.processor.SampleProcessor;
import com.flipkart.apache.camel.processor.SampleResponseProcessor;
import com.google.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

public class MultiProcessorRoute extends RouteBuilder {

    @Inject
    public MultiProcessorRoute(CamelContext context) {
        super(context);
    }

    public void configure() throws Exception {
        from("direct:GetMPData")
                .process(new SampleProcessor())
                .process(new SampleResponseProcessor())
                .convertBodyTo(SampleResponse.class)
                .end();
    }
}
