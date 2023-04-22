package com.example.httpinterface.infra.config;

import com.example.httpinterface.application.HttpQueryService;
import com.example.httpinterface.application.OEmbedService;
import com.example.httpinterface.application.SimpleOEmbedService;
import com.example.httpinterface.domain.DelegateOEmbedUrlConverter;
import com.example.httpinterface.infra.RestTemplateQueryService;
import com.example.httpinterface.infra.WebClientQueryService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public HttpQueryService restTemplateQueryService(RestTemplateBuilder builder) {
        return new RestTemplateQueryService(builder);
    }

    @Bean
    public HttpQueryService webClientQueryService() {
        return new WebClientQueryService();
    }

    @Bean
    public OEmbedService oEmbedService(HttpQueryService webClientQueryService, DelegateOEmbedUrlConverter delegateOEmbedUrlConverter) {
        return new SimpleOEmbedService(webClientQueryService, delegateOEmbedUrlConverter);
    }

}
