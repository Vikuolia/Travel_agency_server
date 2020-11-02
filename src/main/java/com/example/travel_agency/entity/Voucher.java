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
@Table(name = "VOUCHER")
public class Voucher {

    @Id
    private UUID voucherId;

    private String name;
    private Date date;
    private int duration;
    private int max_people;
    private double price;

    @ManyToMany(mappedBy = "vouchers")
    Set<Order> orders;

    public Voucher(String name, Date date, int duration, int max_people, int price){
        this.voucherId = UUID.randomUUID();
        this.date = date;
        this.duration = duration;
        this.max_people = max_people;
        this.price = price;
    }

    public double getPrice(){return this.price;}

    public int getMax_people(){return this.max_people;}

    public String getName(){return this.name;}
}
