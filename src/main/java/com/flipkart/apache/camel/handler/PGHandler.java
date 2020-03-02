package com.flipkart.apache.camel.handler;

import com.flipkart.apache.camel.model.service.InitiateRequest;
import com.flipkart.apache.camel.model.service.InitiateResponse;

public interface PGHandler {

    InitiateResponse initiate(InitiateRequest initiateRequest);
}
