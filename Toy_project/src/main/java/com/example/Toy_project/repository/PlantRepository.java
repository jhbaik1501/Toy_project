package com.example.Toy_project.repository;

import com.example.Toy_project.domain.Plant;
import com.example.Toy_project.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlantRepository {

    private final EntityManager em;

    public void save(Plant plant){
        em.persist(plant);
    }

}
