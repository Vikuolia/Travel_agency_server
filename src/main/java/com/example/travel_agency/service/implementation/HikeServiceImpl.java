package com.example.travel_agency.service.implementation;

import com.example.travel_agency.entity.Hike;
import com.example.travel_agency.entity.Instructor;
import com.example.travel_agency.repository.HikeRepository;
import com.example.travel_agency.service.HikeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HikeServiceImpl implements HikeService {

    @Autowired
    private HikeRepository hikeRepository;

    @Override
    public Hike addHike(Hike newHike) {
        return hikeRepository.save(newHike);
    }

    @Override
    public List<Hike> getAll() {
        return (List<Hike>)hikeRepository.findAll();
    }

    @Override
    public Hike getById(String id) throws NotFoundException {
        Optional<Hike> optionalHike = hikeRepository.findById(id);
        if(optionalHike.isPresent()) return hikeRepository.findById(id).get();
        else throw new NotFoundException(String.format("Hike with id: %s does not exist", id));
    }

    @Override
    public void deleteById(String id) {
        hikeRepository.deleteById(id);
    }

    @Override
    public List<Hike> getAvailable() {
        return hikeRepository.findAllHikeByDateAfter(new Date());
    }

    @Override
    public void deleteNotAvailable() {
        hikeRepository.deleteAllHikeByDateBefore(new Date());
    }

    @Override
    public void setInstructor(Hike hike, Instructor instructor) {
        hike.setInstructor(instructor);
    }

    @Override
    public void changeInstructor(Hike hike, Instructor instructor) {
        hike.changeInstructor(instructor);
    }
}
