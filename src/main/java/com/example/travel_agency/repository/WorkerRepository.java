package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, String> {
}
