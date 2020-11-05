package com.example.travel_agency.service.implementation;

import com.example.travel_agency.entity.Hike;
import com.example.travel_agency.entity.Instructor;
import com.example.travel_agency.repository.HikeRepository;
import com.example.travel_agency.service.HikeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HikeServiceImpl implements HikeService {

    private final HikeRepository hikeRepository;

    @Autowired
    public HikeServiceImpl(HikeRepository hikeRepository) {
        this.hikeRepository = hikeRepository;
    }

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return hikeRepository.findAllByDateAfter(sdf.format(new Date()));
    }

    @Override
    public void deleteNotAvailable() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        hikeRepository.deleteAllHikeByDateBefore(sdf.format(new Date()));
    }

    @Override
    public void changeInstructor(Hike hike, Instructor instructor) {
        hike.changeInstructor(instructor);
    }
}
