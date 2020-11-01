package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Hike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HikeRepository extends CrudRepository<Hike, String> {
}
