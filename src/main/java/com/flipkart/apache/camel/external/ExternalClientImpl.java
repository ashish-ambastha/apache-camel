package com.flipkart.apache.camel.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.apache.camel.model.api.SandboxServerRequest;
import com.flipkart.apache.camel.model.api.SandboxServerResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class ExternalClientImpl implements ExternalClient {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public SandboxServerResponse getInitiateResponse(SandboxServerRequest serverRequest) {
        OkHttpClient client = new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder().url("http://localhost:1234/1.0/payment/camel/poc/test");
        requestBuilder.post(RequestBody.create(JSON, serverRequest.toString()));
        Request request = requestBuilder.build();

        SandboxServerResponse sandboxServerResponse = null;

        try {
            String responseBody;
            okhttp3.Response response = client.newCall(request).execute();
            int responseCode = response.code();
            if (response.isSuccessful()) {
                System.out.println("Successful response received with response code as " + responseCode);
            } else {
                System.out.println("response received with response code as " + responseCode);
            }
            responseBody = response.body().string();
            sandboxServerResponse = new ObjectMapper().readValue(responseBody, SandboxServerResponse.class);
        } catch (IOException e) {
            System.out.println("eternal service error");
        }

        return sandboxServerResponse;
    }
}
