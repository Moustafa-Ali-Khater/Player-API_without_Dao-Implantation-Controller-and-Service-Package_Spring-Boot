package com.spring.player.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8080/
@Controller
@RequestMapping("")
public class TestingController {

    // http://localhost:8080/profile
    @GetMapping("/profile")
    public String test(Model model){
        model.addAttribute("name","Eslam Khder");
        return "home";
    }
}
