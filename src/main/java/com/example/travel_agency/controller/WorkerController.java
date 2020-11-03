package com.example.travel_agency.controller;


import com.example.travel_agency.entity.Worker;
import com.example.travel_agency.service.WorkerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
@AllArgsConstructor
@NoArgsConstructor
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PostMapping
    public Worker addWorker(@RequestBody Worker worker){
        return workerService.addWorker(worker);
    }

    @GetMapping
    public List<Worker> getAllWorkers(){
        return  workerService.getAll();
    }

    @DeleteMapping("{workerId}")
    public ResponseEntity<Void> deleteWorkerById(@PathVariable String workerId){
        workerService.deleteById(workerId);
        return ResponseEntity.noContent().build();
    }
}
