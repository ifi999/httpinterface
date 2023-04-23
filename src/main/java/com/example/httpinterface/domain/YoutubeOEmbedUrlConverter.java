package com.example.httpinterface.domain;

import com.example.httpinterface.domain.utils.UrlUtils;

import java.util.regex.Pattern;

public class YoutubeOEmbedUrlConverter implements OEmbedUrlConverter {

    @Override
    public boolean convertable(String url) {
        String hostUrl = UrlUtils.getHostUrl(url);

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

}
