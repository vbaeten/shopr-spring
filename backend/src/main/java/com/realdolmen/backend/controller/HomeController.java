package com.realdolmen.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "{status: up}";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String dashboard() {
        return "dashboard";
    }
}
