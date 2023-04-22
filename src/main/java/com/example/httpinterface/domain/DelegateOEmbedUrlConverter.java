package com.example.httpinterface.domain;

import org.apache.commons.validator.routines.UrlValidator;

import java.util.List;

public class DelegateOEmbedUrlConverter {

    private final List<OEmbedUrlConverter> converters;

    public DelegateOEmbedUrlConverter(List<OEmbedUrlConverter> converters) {
        this.converters = converters;
    }

    public String convert(String url) {
        validateUrl(url);

        for (OEmbedUrlConverter converter : converters) {
            if(converter.convertable(url)) {
                return converter.convert(url);
            }
        }

        throw new IllegalArgumentException("Unavailable URL formats. Request URL : " + url);
    }

    public void validateUrl(String url) {
        if (!new UrlValidator().isValid(url)) throw new IllegalArgumentException("Not a valid URL format. Request URL : " + url);
    }

}
