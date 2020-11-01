package com.example.travel_agency.service;

import com.example.travel_agency.entity.Hike;

import java.util.List;

public interface HikeService {

    Hike addHike(Hike newHike);

    List<Hike> getAll();

    List<Hike> getAvailable();

    Hike getByName(String name);

    void deleteById(String Id);

    void deleteNotAvailable();
}
