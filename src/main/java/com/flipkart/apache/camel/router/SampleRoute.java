package com.flipkart.apache.camel.router;

import com.flipkart.apache.camel.model.SampleResponse;
import com.flipkart.apache.camel.processor.SampleProcessor;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

public class SampleRoute extends RouteBuilder {

    public SampleRoute(CamelContext context) {
        super(context);
    }

    public void configure() throws Exception {
        from("direct:GetData")
                .process(new SampleProcessor())
                .convertBodyTo(SampleResponse.class)
                .end();
    }
}
