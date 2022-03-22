package com.example.Toy_project.controller;

import com.example.Toy_project.domain.Environment;
import com.example.Toy_project.domain.Plant;
import com.example.Toy_project.domain.User;
import com.example.Toy_project.service.PlantService;
import com.example.Toy_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PlantService plantService;

    @PostMapping("/api/createAccount")
    public String createUser(@RequestBody User user){
        System.out.println("User : " + user.getName() + user.getAge());
        userService.join(user);
        return "가입 완료";
    } // 회원 가입

    @PostMapping("/api/createPlant")
    public String createPlant(@RequestBody Plant plant){
        boolean b = plantService.save(plant);
        if(b){
            return "식물 저장 완료";
        }
        else{
            return "식물을 이미 4개 등록하였습니다.";
        }
    }

    @GetMapping("/api/UserList")
    public List<User> getUserList(){
        return userService.findAllUser();
    }

    @GetMapping("/api/UserPlant")
    public List<Plant> getUserPlant (@RequestParam(value = "id", defaultValue = "") Long id){
        return userService.findAllPlantByUser(id);
    }

}
