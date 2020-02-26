package com.flipkart.apache.camel.resource;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.flipkart.apache.camel.adaptor.InitiateRequestAdaptor;
import com.flipkart.apache.camel.adaptor.InitiateResponseAdaptor;
import com.flipkart.apache.camel.manager.TestRouteManager;
import com.flipkart.apache.camel.manager.TransactionManager;
import com.flipkart.apache.camel.model.api.*;
import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/1.0/payment/camel/poc")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api
public class SampleResource {

    private TestRouteManager testRouteManager;
    private TransactionManager transactionManager;

    @Inject
    public SampleResource(TestRouteManager testRouteManager, TransactionManager transactionManager) {
        this.testRouteManager = testRouteManager;
        this.transactionManager = transactionManager;
    }

    @POST
    @Path("/")
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "POC", tags = "v1", response = SampleResponse.class)
    public SampleResponse getSampleResponse(SampleRequest sampleRequest) throws Exception {
        return testRouteManager.getSampleResponse(sampleRequest);
    }

    @POST
    @Path("/mp")
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "POCMultiProcessor", tags = "v1", response = SampleResponse.class)
    public SampleResponse getMPSampleResponse(SampleRequest sampleRequest) {
        return testRouteManager.getMultiProcessorSampleResponse(sampleRequest);
    }

    @POST
    @Path("/initiate")
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "Initiate", tags = "v1", response = InitiateResponse.class)
    public InitiateResponse initiate(InitiateRequest initiateRequest) {
        com.flipkart.apache.camel.model.service.InitiateRequest request = InitiateRequestAdaptor.adaptToServiceModel(initiateRequest);
        com.flipkart.apache.camel.model.service.InitiateResponse response = transactionManager.initiate(request);
        return InitiateResponseAdaptor.adaptToApiModel(response);
    }

    @POST
    @Path("/test")
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "Test", tags = "v1", response = SandboxServerResponse.class)
    public SandboxServerResponse initiate(SandboxServerRequest initiateRequest) {
        SandboxServerResponse sandboxServerResponse = new SandboxServerResponse();
        sandboxServerResponse.setResponseCode("SUCCESS");
        sandboxServerResponse.setResponseStatus("SUCCESS");
        sandboxServerResponse.setTransactionId("PZT1");
        sandboxServerResponse.setTransactionRefId("REF1");
        return sandboxServerResponse;
    }
}
