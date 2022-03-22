package com.example.Toy_project.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Plant {

    @Id @GeneratedValue
    @Column(name = "plant_id")
    private Long id;

    @JsonManagedReference // 순환참조 방지 -> 이거 이해가 너무 어려움.. 그냥 쓰자.. 다대 일 관계 사용해서 생기는 오류인듯..
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String species;

    public void setMember(User user){
        this.user = user;
        user.getPlants().add(this);
    }
}
