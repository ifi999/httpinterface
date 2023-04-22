package com.example.httpinterface.application;

import com.example.httpinterface.domain.DelegateOEmbedUrlConverter;

import java.util.Map;

public class SimpleOEmbedService implements OEmbedService {

    private final HttpQueryService httpQueryService;
    private final DelegateOEmbedUrlConverter delegateOEmbedUrlConverter;

    public SimpleOEmbedService(HttpQueryService httpQueryService
            , DelegateOEmbedUrlConverter delegateOEmbedUrlConverter) {
        this.httpQueryService = httpQueryService;
        this.delegateOEmbedUrlConverter = delegateOEmbedUrlConverter;
    }

    @Override
    public Map<String, Object> getOEmbedData(String url) {
        String requestUrl = delegateOEmbedUrlConverter.convert(url);
        return httpQueryService.query(requestUrl);
    }

}
