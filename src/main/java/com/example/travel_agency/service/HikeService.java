package com.example.travel_agency.service;

import com.example.travel_agency.entity.Hike;
import com.example.travel_agency.entity.Instructor;
import javassist.NotFoundException;

import java.util.List;

public interface HikeService {

    Hike addHike(Hike newHike);

    List<Hike> getAll();

    List<Hike> getAvailable();

    Hike getById(String id) throws NotFoundException;

    void deleteById(String id);

    void deleteNotAvailable();

    void changeInstructor(Hike hike, Instructor instructor);
}
