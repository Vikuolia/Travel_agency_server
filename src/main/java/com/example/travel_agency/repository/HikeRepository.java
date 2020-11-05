package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Hike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HikeRepository extends JpaRepository<Hike, String> {
    List<Hike> findAllByDateAfter(String date);
    void deleteAllHikeByDateBefore(String date);
}
