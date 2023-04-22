package com.example.httpinterface.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class YoutubeOEmbedUrlConverter implements OEmbedUrlConverter {

    private static final Logger log = LoggerFactory.getLogger(YoutubeOEmbedUrlConverter.class);

    @Override
    public boolean convertable(String url) {
        String hostUrl = getHostUrl(url);

        switch (hostUrl) {
            case "www.youtube.com":
            case "youtube.com":
            case "youtu.be":
                break;
            default:
                return false;
        }

        if (Pattern.compile("(https://.*.youtube.com/watch.*)").matcher(url).find()
                || Pattern.compile("(https://.*.youtube.com/v.*)").matcher(url).find()
                || Pattern.compile("(https://.*.youtube.com/playlist?list=.*)").matcher(url).find()
                || Pattern.compile("(https://.*.youtube.com/shorts.*)").matcher(url).find()
                || Pattern.compile("(https://youtube.com/playlist?list=.*)").matcher(url).find()
                || Pattern.compile("(https://youtu.be/.*)").matcher(url).find()) {
            return true;
        }

        return false;
    }

    @Override
    public String convert(String url) {
        return "https://www.youtube.com/oembed?url=" + url;
    }

    public String getHostUrl(String url) {
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

}
