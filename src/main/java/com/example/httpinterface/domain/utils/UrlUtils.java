package com.example.httpinterface.domain.utils;

import com.example.httpinterface.domain.YoutubeOEmbedUrlConverter;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtils {

    private UrlUtils() {}

    private static final Logger log = LoggerFactory.getLogger(UrlUtils.class);

    public static String getHostUrl(String url) {
        String hostUrl;

        try{
            hostUrl = new URL(url).getHost();
        }
        catch (MalformedURLException e) {
            log.error("Invalid url : {}", url);
            throw new IllegalArgumentException("Invalid URL pattern.");
        }

        if (hostUrl == null) throw new IllegalArgumentException("This URL pattern is null.");

        return hostUrl;
    }

    public static void validateUrl(String url) {
        if (!new UrlValidator().isValid(url)) throw new IllegalArgumentException("Not a valid URL format. Request URL : " + url);
    }

}
