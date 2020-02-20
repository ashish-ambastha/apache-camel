package com.flipkart.apache.camel.app;

import com.flipkart.apache.camel.config.AppConfig;
import com.flipkart.apache.camel.manager.CamelManger;
import com.flipkart.apache.camel.module.DI;
import com.flipkart.apache.camel.module.SampleModule;
import com.flipkart.apache.camel.resource.SampleResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class ACApplication extends Application<AppConfig> {

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap)
    {
        bootstrap.addBundle(new SwaggerBundle<AppConfig>()
        {
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(AppConfig configuration)
            {
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(AppConfig appConfig, Environment environment) throws Exception {
        DI.install(new SampleModule());
        environment.lifecycle().manage(DI.di().getInstance(CamelManger.class));
        environment.jersey().register(DI.di().getInstance(SampleResource.class));
    }

    public static void main(String[] args) throws Exception{
        new ACApplication().run(args);
    }
}
