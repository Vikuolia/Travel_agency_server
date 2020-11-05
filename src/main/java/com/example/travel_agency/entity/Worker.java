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


@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "worker")
public class Worker {

    @Id
    private String workerId;

    private String name;
    private String surname;
    private Position position;

    @JsonManagedReference(value="order-worker")
    @OneToMany(mappedBy = "seller")
    List<Order> orders;

    public Worker(String name, String surname, Position position){
        this.name = name;
        this.surname = surname;
        this.position = position;
    }
}
