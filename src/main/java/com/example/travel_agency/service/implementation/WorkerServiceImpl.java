package com.example.travel_agency.service.implementation;

import com.example.travel_agency.entity.Worker;
import com.example.travel_agency.repository.WorkerRepository;
import com.example.travel_agency.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker addWorker(Worker newWorker) {
       return workerRepository.save(newWorker);
    }

    @Override
    public List<Worker> getAll() {
        return (List<Worker>) workerRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        workerRepository.deleteById(id);
    }
}
