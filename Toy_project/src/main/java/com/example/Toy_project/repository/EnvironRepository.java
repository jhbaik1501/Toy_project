package com.example.Toy_project.repository;

import com.example.Toy_project.domain.Environment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EnvironRepository {

    private final EntityManager em;

    public void save(Environment environment){
        em.persist(environment);
    }

    public Environment findOne(Long id){
        return em.find(Environment.class, id);
    }

    public Environment findLast (){
        List list = em.createQuery("SELECT E FROM Environment E ORDER BY E.time DESC")
                .setMaxResults(1)
                .getResultList();
        Environment environment = (Environment) list.get(0);
        return environment;
    }

}
