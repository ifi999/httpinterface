package com.example.httpinterface.domain;

import com.example.httpinterface.domain.utils.UrlUtils;

import java.util.regex.Pattern;

public class TwitterOEmbedUrlConverter implements OEmbedUrlConverter {

    @Override
    public boolean convertable(String url) {
        String hostUrl = UrlUtils.getHostUrl(url);

        switch (hostUrl) {
            case "www.twitter.com":
            case "twitter.com":
                break;
            default:
                return false;
        }

        if (Pattern.compile("(https://twitter.com/*)").matcher(url).find()
                || Pattern.compile("(https://twitter.com/*/status/*?)").matcher(url).find()
                || Pattern.compile("(https://*.twiiter.com/*/status/*)").matcher(url).find()) {
            return true;
        }

        return false;
    }

    @Override
    public String convert(String url) {
        return "https://publish.twitter.com/oembed?url=" + url;
    }

}
