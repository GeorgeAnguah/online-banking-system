package com.developersboard.onlinebankingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginDemoController {

    @GetMapping
    public String loginHandler() {
        return "bank-login-demo";
    }
}
