package com.example.travel_agency.service.implementation;

import com.example.travel_agency.entity.Instructor;
import com.example.travel_agency.repository.InstructorRepository;
import com.example.travel_agency.service.InstructorService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> getAll() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Instructor getById(String id) throws NotFoundException {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);
        if(optionalInstructor.isPresent()) return instructorRepository.findById(id).get();
        else throw new NotFoundException(String.format("Instructor with id: %s does not exist", id));
    }

    @Override
    public void deleteById(String id) {
        instructorRepository.deleteById(id);
    }
}
