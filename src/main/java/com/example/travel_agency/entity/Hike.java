package com.example.travel_agency.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EnableAutoConfiguration
@Entity
@Data
@Table(name = "HIKE")
public class Hike {

    @Id
    private String hikeId;

    private String name;
    private String date;
    private int duration;
    private int complexity; //0-6
    private int min_age;
    private int max_people;
    private double price;

    @JsonBackReference(value="hike-instructor")
    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @JsonIgnoreProperties("hikes")
    @ManyToMany(mappedBy = "hikes")
    List<Order> orders;

    public Hike(String name, String date, int duration, int complexity, int min_age, int max_people,
                double price, Instructor instructor){
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.complexity = complexity;
        this.min_age = min_age;
        this.max_people = max_people;
        this.price = price;
        this.instructor = instructor;
    }

    public void changeInstructor(Instructor instructor){
        this.instructor = instructor;
    }

    public double getPrice(){return this.price;}

    public int getComplexity(){return this.complexity;}

    public int getMin_age(){return this.min_age;}

    public int getMax_people(){return  this.max_people;}

    public String getName(){return this.name;}
}
