package com.flipkart.apache.camel.resource;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.flipkart.apache.camel.manager.RouteManager;
import com.flipkart.apache.camel.model.SampleRequest;
import com.flipkart.apache.camel.model.SampleResponse;
import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/1.0/payment/camel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api
public class SampleResource {

    private RouteManager routeManager;

    @Inject
    public SampleResource(RouteManager routeManager) {
        this.routeManager = routeManager;
    }

    @POST
    @Path("/poc")
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "CreatePayment", tags = "v2", response = SampleResponse.class)
    public SampleResponse getSampleResponse(SampleRequest sampleRequest) throws Exception{
        return routeManager.getSampleResponse(sampleRequest);
    }

    @POST
    @Path("/poc/mp")
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "CreatePayment", tags = "v2", response = SampleResponse.class)
    public SampleResponse getMPSampleResponse(SampleRequest sampleRequest) throws Exception{
        return routeManager.getMultiProcessorSampleResponse(sampleRequest);
    }
}
