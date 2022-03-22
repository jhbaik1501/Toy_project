package com.example.Toy_project.service;

import com.example.Toy_project.domain.Environment;
import com.example.Toy_project.repository.EnvironRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EnvironService {

    final private EnvironRepository environRepository;

    @Transactional
    public Long save(Environment environment){
        environRepository.save(environment);
        return environment.getId();
    }

    @Transactional
    public Environment findOne(Long environmentId){
        return environRepository.findOne(environmentId);
    }

    @Transactional
    public Environment findLast(){
        return environRepository.findLast();
    }
}
