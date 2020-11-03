package com.example.travel_agency.controller;

import com.example.travel_agency.entity.Hike;
import com.example.travel_agency.service.HikeService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
@AllArgsConstructor
@NoArgsConstructor
public class HikeController {

    @Autowired
    private HikeService hikeService;

    @PostMapping
    public Hike addHike(@RequestBody Hike hike){
        return hikeService.addHike(hike);
    }

    @GetMapping
    public List<Hike> getAllHikes(){
        return hikeService.getAll();
    }

    @GetMapping
    public List<Hike> getAvailableHikes(){
        return hikeService.getAvailable();
    }

    @GetMapping("{hikeId}")
    public Hike getHikeById(@PathVariable String hikeId) throws NotFoundException {
        return hikeService.getById(hikeId);
    }

    @DeleteMapping("{hikeId}")
    public ResponseEntity<Void> deleteHikeById(@PathVariable String hikeId){
        hikeService.deleteById(hikeId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNotAvailableHikes(){
        hikeService.deleteNotAvailable();
        return ResponseEntity.noContent().build();
    }
}
