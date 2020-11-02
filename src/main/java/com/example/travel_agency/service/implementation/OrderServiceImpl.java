package com.example.travel_agency.service.implementation;

import com.example.travel_agency.entity.*;
import com.example.travel_agency.repository.OrderRepository;
import com.example.travel_agency.service.OrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public List<Order> getClientOrders(Client client) {
        return orderRepository.findAllByClient(client);
    }

    @Override
    public Order getById(String id) throws NotFoundException {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()) return orderRepository.findById(id).get();
        else throw new NotFoundException(String.format("Order with id: %s does not exist", id));
    }

    @Override
    public void deleteById(String id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteClientOrders(Client client) {
        orderRepository.findAllByClient(client);
    }

    @Override
    public void addHike(Order order, Hike hike) {
        order.addHike(hike);
    }

    @Override
    public void addVoucher(Order order, Voucher voucher) {
        order.addVoucher(voucher);
    }

    @Override
    public void sellOrder(Order order) {
        order.updateStatus(Status.sold);
    }

    @Override
    public void cancelOrder(Order order) {
        order.updateStatus(Status.Canceled);
    }

    @Override
    public double getPrice(Order order) {
        double newPrice = 0.0;
        for(Hike hike: order.getHikes()){
            newPrice += hike.getPrice();
        }
        for(Voucher voucher: order.getVouchers()){
            newPrice += voucher.getPrice();
        }
        return newPrice;
    }
}
