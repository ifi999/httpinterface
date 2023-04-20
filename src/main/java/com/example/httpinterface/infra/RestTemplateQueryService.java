package com.example.httpinterface.infra;

import com.example.httpinterface.application.HttpQueryService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateQueryService implements HttpQueryService {

    private final RestTemplate restTemplate;

    public RestTemplateQueryService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public Map<String, Object> query(String url) {
        return restTemplate.getForObject(url, Map.class);
    }

}
