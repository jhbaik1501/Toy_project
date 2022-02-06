package com.example.Toy_project.controller;

import com.example.Toy_project.DataRepositoryEx;
import com.example.Toy_project.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class controllerTest2 {

    private final DataRepositoryEx dataRepositoryEx;

    @Autowired
    public controllerTest2(DataRepositoryEx dataRepositoryEx) {
        this.dataRepositoryEx = dataRepositoryEx;
    }


    @GetMapping("/home2")
    public String getHome(Model model){
        Environment environment = dataRepositoryEx.getNowEnvironment();
        model.addAttribute("environment", environment);
        return "시간 : " + environment.getTime() + " 습도 : " + environment.getHumidity() + "% 조도 : " +
                environment.getIlluminace() + "% 온도 : " + environment.getTemperature() + "도 ";
    }
}
