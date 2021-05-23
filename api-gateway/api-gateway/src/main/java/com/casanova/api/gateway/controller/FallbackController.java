package com.casanova.api.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/customerServiceFallback")
    public String customerServiceFallbackMethod(){
        return "Customer Service is taking longer than usual."+
                " Please try again later.";
    }

    @GetMapping("/simcardServiceFallback")
    public String simCardServiceFallbackMethod(){
        return "SimCard Service is taking longer than usual."+
                " Please try again later.";
    }
}
