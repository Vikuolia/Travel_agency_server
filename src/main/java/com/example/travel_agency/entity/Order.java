package com.example.travel_agency.entity;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@EnableAutoConfiguration
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    private UUID orderId;
    private Date date;
    private int price;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "order_hike",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "hike_id")
    )
    List<Hike> hikes;

    @ManyToMany
    @JoinTable(
            name = "order_voucher",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "voucher_id")
    )
    List<Voucher> vouchers;


    public Order(Client client){
        this.orderId = UUID.randomUUID();
        this.client = client;
        this.date = new Date();
        this.price = 0;
        this.status = Status.inProgress;
    }
}
