package com.example.travel_agency.service;

import com.example.travel_agency.entity.Instructor;
import javassist.NotFoundException;

import java.util.List;

public interface InstructorService {

    Instructor addInstructor(Instructor instructor);

    List<Instructor> getAll();

    Instructor getById(String id) throws NotFoundException;

    void deleteById(String id);
}
