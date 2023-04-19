package com.example.httpinterface.presentation;

import com.example.httpinterface.application.OEmbedService;
import org.springframework.stereotype.Controller;

@Controller
public class OEmbedController {

    private final OEmbedService oEmbedService;

    public OEmbedController(OEmbedService oEmbedService) {
        this.oEmbedService = oEmbedService;
    }
}
