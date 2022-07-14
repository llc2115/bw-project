package com.mz.config;

import com.mz.filter.BearerAuthorizationIntercept;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * rest模板配置类
 * Created by Administrator on 2022/7/1.
 */
@Configuration
public class RestTemplateConfig {

    @Value("${azure_username}")
    private String azure_username;

    @Value("${azure_password}")
    private String azure_password;

    @Value("${accessTokenGitHub}")
    private String accessTokenGitHub;

    /**
     * azure 基于BasicAuth方式认证
     * 用于 azure调用
     * @return
     */
    @Bean(name="azureRestTemplate")
    public RestTemplate azureRestTemplate(){

        RestTemplate restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new BasicAuthenticationInterceptor(azure_username,azure_password));

        restTemplate.setInterceptors(interceptors);

        /**
         * 超时设定
         */
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(6000);
        httpRequestFactory.setConnectTimeout(6000);
        httpRequestFactory.setReadTimeout(6000);

        return restTemplate;
    }

    /**
     * github 基于oauth2方式认证
     * 用于github调用
     * @return
     */
    @Bean(name="gitHubRestTemplate")
    public RestTemplate gitHubRestTemplate(){

        RestTemplate restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new BearerAuthorizationIntercept(accessTokenGitHub));

        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }


    /**
     * 后续有其他工具调用自己往下加
     */

}
