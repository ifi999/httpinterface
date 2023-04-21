package com.example.httpinterface.domain;

public interface OEmbedUrlConverter {

    boolean convertable(String url);
    String convert(String url);

}
