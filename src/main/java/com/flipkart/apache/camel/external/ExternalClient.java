package com.flipkart.apache.camel.external;

import com.flipkart.apache.camel.model.api.SandboxServerRequest;
import com.flipkart.apache.camel.model.api.SandboxServerResponse;

public interface ExternalClient {
    SandboxServerResponse getInitiateResponse(SandboxServerRequest serverRequest);
}
