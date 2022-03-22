package com.example.Toy_project.service;

import com.example.Toy_project.domain.Plant;
import com.example.Toy_project.domain.User;
import com.example.Toy_project.repository.PlantRepository;
import com.example.Toy_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantService {

    final private PlantRepository plantRepository;
    final private UserRepository userRepository;

    @Transactional
    public boolean save(Plant plant){

        Long userId = plant.getUser().getId();
        if(checkPlantNum(userId)){
            plantRepository.save(plant);
            return true;
        }
        else{
            return false; // 식물 개수가 4개 이상이므로 false 반환
        }
    }

    public boolean checkPlantNum(Long userId){

        if(userRepository.findUserPlant(userId).size() >= 4){
            return false;
        }
        return true;
    }

}
