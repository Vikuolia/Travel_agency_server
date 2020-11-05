package com.example.travel_agency.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@EnableAutoConfiguration
@Entity
@Data
@AllArgsConstructor
@Table(name = "VOUCHER")
public class Voucher {

    @Id
    private String voucherId;

    private String name;
    private String date;
    private int duration;
    private int max_people;
    private double price;

    @JsonIgnoreProperties("vouchers")
    @ManyToMany(mappedBy = "vouchers")
    List<Order> orders;

    public Voucher(String name, String date, int duration, int max_people, int price){
        this.date = date;
        this.duration = duration;
        this.max_people = max_people;
        this.price = price;
    }

    public double getPrice(){return this.price;}

    public int getMax_people(){return this.max_people;}

    public String getName(){return this.name;}
}
