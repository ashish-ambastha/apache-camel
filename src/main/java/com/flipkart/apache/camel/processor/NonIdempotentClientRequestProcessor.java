package com.flipkart.apache.camel.processor;

import com.flipkart.apache.camel.dao.DAO;
import com.flipkart.apache.camel.external.ExternalClient;
import com.flipkart.apache.camel.model.api.SandboxServerRequest;
import com.flipkart.apache.camel.model.api.SandboxServerResponse;
import com.flipkart.apache.camel.model.db.TransactionAudit;
import com.google.inject.Inject;

public class NonIdempotentClientRequestProcessor
        extends ClientRequestProcessor<SandboxServerRequest, SandboxServerResponse> {

    private ExternalClient externalClient;
    private DAO dao;

    @Inject
    public NonIdempotentClientRequestProcessor(ExternalClient externalClient, DAO dao) {
        this.externalClient = externalClient;
        this.dao = dao;
    }

    public SandboxServerResponse doProcess(SandboxServerRequest serverRequest) {

        SandboxServerResponse sandboxServerResponse = externalClient.getInitiateResponse(serverRequest);
        boolean isIdempotent = isIdempotentResponse(sandboxServerResponse);
        if (isIdempotent) {
            return sandboxServerResponse;
        } else {
            sandboxServerResponse.setResponseCode("NON_IDEMPOTENT_RESPONSE");
            sandboxServerResponse.setResponseStatus("FAILED");

            return sandboxServerResponse;
        }
    }

    private boolean isIdempotentResponse(SandboxServerResponse sandboxServerResponse) {

        TransactionAudit auditDetails = dao.getAuditDetails(sandboxServerResponse.getTransactionId());
        return auditDetails != null && auditDetails.getResponse().equals(sandboxServerResponse.toString());
    }
}
