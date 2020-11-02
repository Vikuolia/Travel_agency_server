package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Hike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HikeRepository extends CrudRepository<Hike, String> {
    List<Hike> findAllHikeByDateAfter(Date date);
    void deleteAllHikeByDateBefore(Date date);
}
