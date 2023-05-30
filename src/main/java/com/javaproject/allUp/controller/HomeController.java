package com.javaproject.allUp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/test")
    public String test_mapping() {
        return "test";
    }

    @GetMapping("/howto-help")
    public String howtohelp_mapping() {
        return "howto-help";
    }
}
