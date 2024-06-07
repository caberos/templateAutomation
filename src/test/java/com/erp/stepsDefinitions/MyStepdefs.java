package com.erp.stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.validation.constraints.AssertTrue;
import org.erp.api.client.ClientRequest;
import org.erp.api.client.FactoryRequest;
import org.erp.api.client.RequestApi;
import org.erp.api.client.ResponseApi;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import static org.erp.api.configuration.Configuration.HOST;
import static org.erp.api.configuration.Configuration.VERSION;
import static org.junit.Assert.assertTrue;

public class MyStepdefs {

    ResponseApi response1 = new ResponseApi();

    RequestApi requestApi = new RequestApi();
    Map<String, String> variables = new HashMap<>();
    private HttpResponse<String> response;

    @Given("^send (POST|PUT|DELETE|GET) method with '(.*)' services and '(.*)' request$")
    public void sendGetMethodWithEmployeeGetAllobjects(String method, String service, String request, String jsonBody) throws IOException, InterruptedException {
        requestApi.setUrl(HOST + VERSION + this.replaceVariables(service) + "/" + this.replaceVariables(request));
        System.out.println(method + requestApi.getUrl());

        if (!jsonBody.isEmpty() && (method.equals("POST") || method.equals("PUT"))) {
            requestApi.setBody(this.replaceVariables(jsonBody));
            System.out.println(jsonBody);
        }
        ClientRequest clientRequest = FactoryRequest.make(method);

        response = clientRequest.send(requestApi);
    }


    private String replaceVariables(String value) {
        for (String key : this.variables.keySet()
        ) {
            value = value.replace(key, this.variables.get(key));
        }
        return value;
    }

    @Then("the status code is {int}")
    public void theStatusCodeIs(int code) {
        assertTrue(response.statusCode() == code);
    }


}
