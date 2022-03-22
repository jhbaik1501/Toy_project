package com.example.Toy_project.service;

import com.example.Toy_project.domain.Environment;
import com.example.Toy_project.domain.Plant;
import com.example.Toy_project.domain.User;
import com.example.Toy_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    final private UserRepository userRepository;

    @Transactional
    public User findUser(Long id){
        return userRepository.findOne(id);
    }

    @Transactional
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @Transactional
    public List<Plant> findAllPlantByUser(Long id){
        return userRepository.findUserPlant(id);
    }

    @Transactional
    public void join(User user) {
        userRepository.save(user);
    }
}
