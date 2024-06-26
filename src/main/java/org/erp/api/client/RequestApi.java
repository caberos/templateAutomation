package org.erp.api.client;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.HashMap;
import java.util.Map;

public class RequestApi {
    private String url;
    private Map<String, String> params = new HashMap<>();
    private MultivaluedMap<String, Object> headers= new MultivaluedHashMap<>();
    private String body;

    public RequestApi() { }

    public RequestApi(String url, Map<String, String> params, MultivaluedMap<String, Object> headers, String body) {
        this.url = url;
        this.params = params;
        this.headers = headers;
        this.body = body;
    }

    public void addHeaders(String attribute,String value){
        this.headers.add(attribute,value);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public MultivaluedMap<String, Object> getHeaders() {
        return headers;
    }

    public void setHeaders(MultivaluedMap<String, Object> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
