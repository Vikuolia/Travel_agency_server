package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Voucher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VoucherRepository extends CrudRepository<Voucher, String> {
    List<Voucher> findByName(String name);
    List<Voucher> findByDateAfter(Date date);
    void deleteAllByDateBefore(Date date);
}
