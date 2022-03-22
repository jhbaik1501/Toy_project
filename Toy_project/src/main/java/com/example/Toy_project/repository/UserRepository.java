package com.example.Toy_project.repository;

import com.example.Toy_project.domain.Plant;
import com.example.Toy_project.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User findOne(Long id){
        return em.find(User.class, id);
    }

    public List<User> findAll(){
        List<User> list = em.createQuery("SELECT U FROM User U").getResultList();
        return list;
    }

    public List<Plant> findUserPlant(Long id){
        List<Plant> list = em.createQuery("SELECT P FROM Plant P JOIN P.user U WHERE U.id = :id", Plant.class)
                .setParameter("id", id)
                .getResultList();
        return list;
    }
}
