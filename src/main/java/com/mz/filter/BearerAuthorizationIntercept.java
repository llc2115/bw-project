package com.mz.filter;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by Administrator on 2022/7/1.
 */
public class BearerAuthorizationIntercept implements ClientHttpRequestInterceptor {

    private String accessToken;

    public BearerAuthorizationIntercept(String accessToken) {
        this.accessToken=accessToken;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        httpRequest.getHeaders().add("Authorization","Bearer "+this.accessToken);

        return clientHttpRequestExecution.execute(httpRequest,bytes) ;
    }

}
