package com.example.travel_agency.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@EnableAutoConfiguration
@Entity
@Data
@Table(name = "ORDERS")
public class Order {

    @Id
    private String orderId;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private Status status;

    @JsonBackReference(value="order-client")
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @JsonBackReference(value="order-worker")
    @ManyToOne
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker seller;

    @ManyToMany
    @JsonIgnoreProperties("orders")
    @JoinTable(
            name = "order_hike",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "hike_id")
    )
    List<Hike> hikes = new ArrayList<>();

    @ManyToMany
    @JsonIgnoreProperties("orders")
    @JoinTable(
            name = "order_voucher",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "voucher_id")
    )
    List<Voucher> vouchers = new ArrayList<>();

    public Order(Client client, Worker seller){
        this.client = client;
        this.seller = seller;
        this.date = new Date().toString();
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
