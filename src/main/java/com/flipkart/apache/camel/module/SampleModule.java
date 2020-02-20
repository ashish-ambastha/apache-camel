package com.flipkart.apache.camel.module;

import com.google.inject.AbstractModule;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class SampleModule extends AbstractModule {
    protected void configure() {
        bind(CamelContext.class).to(DefaultCamelContext.class).asEagerSingleton();
    }
}
