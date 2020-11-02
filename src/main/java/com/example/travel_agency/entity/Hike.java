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
    private Date date;
    private int duration;
    private int complexity; //0-6
    private int min_age;
    private int  max_people;
    private double price;

    @ManyToOne
    @MapsId("instructorId")
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToMany(mappedBy = "hikes")
    Set<Order> orders;

    public Hike(String name, Date date, int duration, int complexity, int min_age, int max_people,
                double price){
        this.hikeId = UUID.randomUUID();
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.complexity = complexity;
        this.min_age = min_age;
        this.max_people = max_people;
        this.price = price;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void changeInstructor(Instructor instructor){
        this.instructor = instructor;
    }

    public double getPrice(){return this.price;}

    public int getComplexity(){return this.complexity;}

    public int getMin_age(){return this.min_age;}

    public int getMax_people(){return  this.max_people;}
}
