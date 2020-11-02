package com.example.travel_agency.service;

import com.example.travel_agency.entity.*;
import javassist.NotFoundException;

import java.util.List;

public interface OrderService {

    Order addOrder(Order newOrder);

    List<Order> getAll();

    List<Order> getClientOrders(Client client);

    Order getById(String id) throws NotFoundException;

    void deleteById(String id);

    void deleteClientOrders(Client client);

    String addHike(Order order, Hike hike);

    String addVoucher(Order order, Voucher voucher);

    double getPrice(Order order);

    void sellOrder(Order order);

    void cancelOrder(Order order);
}
