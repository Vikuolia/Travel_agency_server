package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Client;
import com.example.travel_agency.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
    List<Order> findAllByClient(Client client);
    void deleteAllByClient(Client client);
}
