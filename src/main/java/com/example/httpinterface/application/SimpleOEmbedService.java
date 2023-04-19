package com.example.httpinterface.application;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SimpleOEmbedService implements OEmbedService {

    @Override
    public Map<String, Object> getOEmbedData(String url) {
        return null;
    }

}
