package com.example.travel_agency.service.implementation;

import com.example.travel_agency.entity.Client;
import com.example.travel_agency.repository.ClientRepository;
import com.example.travel_agency.service.ClientService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client addClient(Client newClient) {
        return clientRepository.save(newClient);
    }

    @Override
    public List<Client> getAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client getById(String id) throws NotFoundException {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()) return clientRepository.findById(id).get();
        else throw new NotFoundException(String.format("Client with id: %s does not exist", id));
    }

    @Override
    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void makeFrequentBuyer(Client client) {
        client.makeFrequentBuyer();
    }
}
