package com.example.travel_agency.entity;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
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

    public Worker(String name, String surname, Position position){
        this.workerId = UUID.randomUUID();
        this.name = name;
        this.position = position;
    }
}
