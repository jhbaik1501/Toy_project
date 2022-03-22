package com.example.Toy_project.controller;

import com.example.Toy_project.domain.Environment;
import com.example.Toy_project.service.EnvironService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnvironController {

    private final EnvironService environService;


    @GetMapping("/api/first")
    public Environment getHome(Model model){
        Environment environment = environService.findLast();
        model.addAttribute("environment", environment);
        return environment;
    } // 가장 최근의 값 리턴.



}
