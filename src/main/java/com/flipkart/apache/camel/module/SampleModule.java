package com.flipkart.apache.camel.module;

import com.flipkart.apache.camel.external.ExternalClient;
import com.flipkart.apache.camel.external.ExternalClientImpl;
import com.google.inject.AbstractModule;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class SampleModule extends AbstractModule {
    protected void configure() {
        bind(CamelContext.class).to(DefaultCamelContext.class).asEagerSingleton();
        bind(ExternalClient.class).to(ExternalClientImpl.class);
    }
}
