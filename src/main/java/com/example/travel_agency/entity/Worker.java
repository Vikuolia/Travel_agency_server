package com.example.travel_agency.entity;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;


@EnableAutoConfiguration
@Entity
@NoArgsConstructor
@Table(name = "worker")
public class Worker {

    @Id
    private UUID workerId;
    private String name;
    private String surname;
    private Position position;

    @OneToMany(mappedBy = "seller")
    Set<Order> orders;

    public Worker(String name, String surname, Position position){
        this.workerId = UUID.randomUUID();
        this.name = name;
        this.position = position;
    }
}
