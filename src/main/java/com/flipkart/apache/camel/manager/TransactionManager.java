package com.flipkart.apache.camel.manager;

import com.flipkart.apache.camel.handler.PGHandler;
import com.flipkart.apache.camel.model.service.InitiateRequest;
import com.flipkart.apache.camel.model.service.InitiateResponse;
import com.google.inject.Inject;

public class TransactionManager {

    @Inject
    private PGHandler pgHandler;

    public InitiateResponse initiate(InitiateRequest initiateRequest) {
        return pgHandler.initiate(initiateRequest);
    }

}
