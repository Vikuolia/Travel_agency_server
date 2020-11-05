package com.example.travel_agency.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@EnableAutoConfiguration
@Entity
@Data
@Table(name = "INSTRUCTOR")
public final class Instructor{

    @Id
    private String instructorId;

    private String name;
    private String surname;
    private int background;

    @JsonManagedReference(value="hike-instructor")
    @OneToMany(mappedBy = "instructor")
    private List<Hike> hikes;

    public Instructor(String name, String surname, int background){
        this.name = name;
        this.surname = surname;
        this.background = background;
    }
}
