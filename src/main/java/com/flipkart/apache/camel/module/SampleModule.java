package com.flipkart.apache.camel.module;

import com.flipkart.apache.camel.dao.DAO;
import com.flipkart.apache.camel.dao.SampleDAO;
import com.flipkart.apache.camel.external.ExternalClient;
import com.flipkart.apache.camel.external.ExternalClientImpl;
import com.flipkart.apache.camel.handler.PGHandler;
import com.flipkart.apache.camel.handler.SandboxPGHandler;
import com.flipkart.apache.camel.model.api.SandboxServerRequest;
import com.flipkart.apache.camel.model.api.SandboxServerResponse;
import com.flipkart.apache.camel.processor.ClientRequestProcessor;
import com.flipkart.apache.camel.processor.NonIdempotentClientRequestProcessor;
import com.flipkart.apache.camel.processor.initiate.sandbox.IdempotentRequestProcessor;
import com.flipkart.apache.camel.router.InitiateRoute;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class SampleModule extends AbstractModule {
    protected void configure() {
        bind(CamelContext.class).to(DefaultCamelContext.class).asEagerSingleton();
        bind(ExternalClient.class).to(ExternalClientImpl.class);
        bind(PGHandler.class).to(SandboxPGHandler.class);
        bind(DAO.class).to(SampleDAO.class);
        bind(new TypeLiteral<ClientRequestProcessor<SandboxServerRequest, SandboxServerResponse>>() {
        }).annotatedWith(Names.named("NonIdempotent")).to(NonIdempotentClientRequestProcessor.class);
        bind(new TypeLiteral<ClientRequestProcessor<SandboxServerRequest, SandboxServerResponse>>() {
        }).annotatedWith(Names.named("Idempotent")).to(IdempotentRequestProcessor.class);
    }

    @Provides
    @Named("nonIdempotentRoute")
    public InitiateRoute nonIdempotentRoute (@Named("NonIdempotent") ClientRequestProcessor<SandboxServerRequest,
            SandboxServerResponse> clientRequestProcessor) {
        return new InitiateRoute(clientRequestProcessor, "direct:initiateNIR");
    }

    @Provides
    @Named("idempotentRoute")
    public InitiateRoute idempotentRoute (@Named("Idempotent") ClientRequestProcessor<SandboxServerRequest,
            SandboxServerResponse> clientRequestProcessor) {
        return new InitiateRoute(clientRequestProcessor, "direct:initiateIR");
    }
}
