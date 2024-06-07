package org.erp.api.client;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class FactoryRequest {
    public static ClientRequest make(String type) {
        switch (type.toLowerCase()) {
            case "put":
                return new PutRequest();
            case "post":
                return new PostRequest();
            case "delete":
                return new DeleteRequest();
            default:
                return new GetRequest();
        }
    }
}
