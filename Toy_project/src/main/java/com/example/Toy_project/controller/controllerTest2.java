package com.example.Toy_project.controller;

import com.example.Toy_project.DataRepositoryEx;
import com.example.Toy_project.Environ_Repository;
import com.example.Toy_project.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class controllerTest2 {

    private final Environ_Repository environ_repository;

    @Autowired
    public controllerTest2(Environ_Repository environ_repository) {
        this.environ_repository = environ_repository;
    }


    @GetMapping("/home2")
    public String getHome(Model model){
        Environment environment = environ_repository.getNowEnvironment();
        model.addAttribute("environment", environment);
        return "시간 : " + environment.getTime() + " 습도 : " + environment.getHumidity() + "% 조도 : " +
                environment.getIlluminace() + "% 온도 : " + environment.getTemperature() + "도 ";
    }
}
