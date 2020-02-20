package com.flipkart.apache.camel.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class AppConfig extends Configuration {

    private String environment;
    private String service;
    private SwaggerBundleConfiguration swagger;

    public String getEnvironment() {
        return environment;
    }

    public String getService() {
        return service;
    }

    public SwaggerBundleConfiguration getSwagger() {
        return swagger;
    }
}
