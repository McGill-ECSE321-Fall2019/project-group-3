package com.ecse321.group3.tutorME.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MainController {

    @RequestMapping("/")
    public String homePage(){
        return "Welcome to Tutor ME: " + System.currentTimeMillis();
    }
}
