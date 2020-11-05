package com.example.travel_agency.controller;

import com.example.travel_agency.entity.Instructor;
import com.example.travel_agency.service.InstructorService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public Instructor addInstructor(@RequestBody Instructor instructor){
        return instructorService.addInstructor(instructor);
    }

    @GetMapping
    public List<Instructor> getAllInstructors(){
        return instructorService.getAll();
    }

    @GetMapping("{instructorId}")
    public Instructor getInstructorById(@PathVariable String instructorId) throws NotFoundException {
        return instructorService.getById(instructorId);
    }

    @DeleteMapping("{instructorId}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable String instructorId){
        instructorService.deleteById(instructorId);
        return ResponseEntity.noContent().build();
    }

}
