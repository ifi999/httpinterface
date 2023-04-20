package com.example.httpinterface.application;

import java.util.Map;

public interface HttpQueryService {

    Map<String, Object> query(String url);

}
