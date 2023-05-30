package com.javaproject.allUp.controller;

import com.javaproject.allUp.models.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/test")
    public String info1() {
        return "test";
    }

    @GetMapping("/howto-help")
    public String info2() {
        return "howto-help";
    }

    @GetMapping("/forum")
    public String forum() {
        return "forum";
    }
}
