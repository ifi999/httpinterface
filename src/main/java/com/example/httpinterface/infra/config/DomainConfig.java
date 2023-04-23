package com.example.httpinterface.infra.config;

import com.example.httpinterface.domain.DelegateOEmbedUrlConverter;
import com.example.httpinterface.domain.OEmbedUrlConverter;
import com.example.httpinterface.domain.TwitterOEmbedUrlConverter;
import com.example.httpinterface.domain.YoutubeOEmbedUrlConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DomainConfig {

    @Bean
    public DelegateOEmbedUrlConverter delegateOEmbedUrlConverter(List<OEmbedUrlConverter> converters) {
        return new DelegateOEmbedUrlConverter(converters);
    }

    @Bean
    public OEmbedUrlConverter youtubeOEmbedUrlConverter() {
        return new YoutubeOEmbedUrlConverter();
    }

    @Bean
    public OEmbedUrlConverter twitterOEmbedUrlConverter() {
        return new TwitterOEmbedUrlConverter();
    }

}
