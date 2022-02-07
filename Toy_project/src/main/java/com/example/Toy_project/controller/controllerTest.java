package com.example.Toy_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerTest {
    @GetMapping("/api/home")
    public String getHome(){
        return "Hello world!zzzzzzzzzzzzzzzzz";
    }
}
