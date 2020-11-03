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

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

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
        orderRepository.deleteAllByClient(client);
    }

    @Override
    public String addHike(Order order, Hike hike) {

        int client_age = order.getClient().getAge();
        int client_background = order.getClient().getBackground();
        int hike_participants = order.getHikes().size();

        if(client_age >= hike.getMin_age() && client_background >= hike.getComplexity() &&
                hike_participants < hike.getMax_people()) {

            order.addHike(hike);
            return String.format("Hike %s is added to order", hike.getName());
        }

        else return String.format("Hike %s is NOT added to order. Choose something else, please", hike.getName());
    }

    @Override
    public String addVoucher(Order order, Voucher voucher) {

        int voucher_participants = order.getVouchers().size();

        if(voucher_participants < voucher.getMax_people()) {
            order.addVoucher(voucher);
            return String.format("Voucher %s is added to order", voucher.getName());
        }
        else return String.format("All vouchers %s are sold. Choose something else, please", voucher.getName());
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
        int count = order.getHikes().size() + order.getVouchers().size();

        for(Hike hike: order.getHikes()){
            newPrice += hike.getPrice();
        }
        for(Voucher voucher: order.getVouchers()){
            newPrice += voucher.getPrice();
        }

        if(order.getClient().isStudent()) newPrice = newPrice * 0.15;
        if(order.getClient().getAge() < 8) newPrice = newPrice * 0.2;
        if(order.getClient().isFrequentBuyer()) newPrice = newPrice * 0.1;
        if(count > 3) newPrice = newPrice * 0.1;

        return newPrice;
    }
}
