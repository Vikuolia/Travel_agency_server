package com.example.travel_agency.entity;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;


@NoArgsConstructor
@EnableAutoConfiguration
@Entity
@Table(name = "INSTRUCTOR")
public final class Instructor{

    @Id
    private UUID instructorId;
    private String name;
    private String surname;
    private int background;

    @OneToMany(mappedBy = "instructor")
    private Set<Hike> hikes;

    public Instructor(String name, String surname, int background){
        this.instructorId = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.background = background;
    }
}
