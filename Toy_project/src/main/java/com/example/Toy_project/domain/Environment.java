package com.example.Toy_project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Environment {

    @Id @GeneratedValue
    @Column(name = "Environment_id")
    private Long id;
    private LocalDateTime time;
    private int Humidity;
    private int Temperature;
    private int illuminace;

}
