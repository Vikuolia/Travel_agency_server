package com.example.travel_agency.entity;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @MapsId("workerId")
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker seller;

    @ManyToMany
    @JoinTable(
            name = "order_hike",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "hike_id")
    )
    List<Hike> hikes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "order_voucher",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "voucher_id")
    )
    List<Voucher> vouchers = new ArrayList<>();

    public Order(Client client, Worker seller){
        this.orderId = UUID.randomUUID();
        this.client = client;
        this.seller = seller;
        this.date = new Date();
        this.price = 0;
        this.status = Status.inProgress;
    }

    public void updateStatus(Status newStatus){
        this.status = newStatus;
    }

    public void addHike(Hike hike){
        hikes.add(hike);
    }

    public void addVoucher(Voucher voucher){
        vouchers.add(voucher);
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public List<Hike> getHikes(){return hikes;}

    public List<Voucher> getVouchers(){return vouchers;}

    public Client getClient(){return this.client;}
}
