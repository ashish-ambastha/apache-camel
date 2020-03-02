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
        Request.Builder requestBuilder = new Request.Builder().url("http://127.0.0.1:1234/aco/1.0/payment/camel/poc/test");
        SandboxServerResponse sandboxServerResponse = null;
        try {
            requestBuilder.post(RequestBody.create(JSON, new ObjectMapper().writeValueAsString(serverRequest)));
            Request request = requestBuilder.build();

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
