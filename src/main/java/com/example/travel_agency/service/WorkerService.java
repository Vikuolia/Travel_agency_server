package com.example.travel_agency.service;

import com.example.travel_agency.entity.Worker;

import java.util.List;

public interface WorkerService {

    Worker addWorker(Worker newWorker);

    List<Worker> getAll();

    void deleteById(String id);
}
