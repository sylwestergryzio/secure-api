package com.kainos.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallbackController {
    @GetMapping("/callback/code/keycloak")
    String ShowCode(@RequestParam String code) {
        return code;
    }
}
