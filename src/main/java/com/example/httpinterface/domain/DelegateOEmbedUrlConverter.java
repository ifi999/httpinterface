package com.example.httpinterface.domain;

import com.example.httpinterface.domain.utils.UrlUtils;

import java.util.List;

public class DelegateOEmbedUrlConverter {

    private final List<OEmbedUrlConverter> converters;

    public DelegateOEmbedUrlConverter(List<OEmbedUrlConverter> converters) {
        this.converters = converters;
    }

    public String convert(String url) {
        UrlUtils.validateUrl(url);

        for (OEmbedUrlConverter converter : converters) {
            if(converter.convertable(url)) {
                return converter.convert(url);
            }
        }

        throw new IllegalArgumentException("Unavailable URL formats. Request URL : " + url);
    }

}
