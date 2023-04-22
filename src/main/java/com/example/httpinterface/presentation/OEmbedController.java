package com.example.httpinterface.presentation;

import com.example.httpinterface.application.OEmbedService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OEmbedController {

    private final OEmbedService oEmbedService;

    public OEmbedController(OEmbedService oEmbedService) {
        this.oEmbedService = oEmbedService;
    }

    @GetMapping("/oembed")
    public ResponseEntity<?> getOembedData(@RequestParam @NonNull String requestUrl) {
        return ResponseEntity.ok(oEmbedService.getOEmbedData(requestUrl));
    }

}
