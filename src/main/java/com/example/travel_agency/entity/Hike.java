package com.example.travel_agency.entity;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@EnableAutoConfiguration
@Entity
@Table(name = "HIKE")
public class Hike {

    @Id
    private UUID hikeId;

    private String name;
    private String surname;
    private Date date;
    private int duration;
    private int complexity; //1-6
    private int min_age;
    private int  max_people;
    private double price;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToMany(mappedBy = "hikes")
    Set<Order> orders;

    public Hike(String name, String surname, Date date, int duration, int complexity, int min_age, int max_people,
                double price, Instructor instructor){
        this.hikeId = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.duration = duration;
        this.complexity = complexity;
        this.min_age = min_age;
        this.max_people = max_people;
        this.price = price;
        this.instructor = instructor;
    }
}
