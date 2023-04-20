package com.example.httpinterface.infra;

import com.example.httpinterface.application.HttpQueryService;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

public class WebClientQueryService implements HttpQueryService {

    private final WebClient webClient;

    public WebClientQueryService() {
        this.webClient = WebClient.builder().build();
    }

    @Override
    public Map<String, Object> query(String url) {
        return webClient.get().uri(url)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
