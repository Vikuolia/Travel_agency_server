package com.example.travel_agency.service;

import com.example.travel_agency.entity.Client;
import javassist.NotFoundException;

import java.util.List;

public interface ClientService {

    Client addClient(Client newClient);

    List<Client> getAll();

    Client getById(String id) throws NotFoundException;

    void deleteById(String id);

    void makeFrequentBuyer(Client client);
}
