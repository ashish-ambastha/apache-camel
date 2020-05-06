package com.flipkart.apache.camel.processor.initiate.sandbox;

import com.flipkart.apache.camel.external.ExternalClient;
import com.flipkart.apache.camel.model.api.SandboxServerRequest;
import com.flipkart.apache.camel.model.api.SandboxServerResponse;
import com.flipkart.apache.camel.processor.ClientRequestProcessor;
import com.google.inject.Inject;

public class IdempotentRequestProcessor extends ClientRequestProcessor<SandboxServerRequest, SandboxServerResponse> {

    private ExternalClient externalClient;

    @Inject
    public IdempotentRequestProcessor(ExternalClient externalClient) {
        this.externalClient = externalClient;
    }

    public SandboxServerResponse doProcess(SandboxServerRequest serverRequest) {
        return externalClient.getInitiateResponse(serverRequest);
    }
}
