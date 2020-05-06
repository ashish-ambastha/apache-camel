package com.flipkart.apache.camel.processor;

import com.flipkart.apache.camel.external.ExternalClient;
import com.google.inject.Inject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public abstract class ClientRequestProcessor<I,O> implements Processor {

    public void process(Exchange exchange) throws Exception {
        I i = (I) exchange.getIn().getBody();
        O o = doProcess(i);
        exchange.getIn().setBody(o);
    }

    public abstract O doProcess(I i);
}
