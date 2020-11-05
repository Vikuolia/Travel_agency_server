package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, String> {
    List<Voucher> findByDateAfter(Date date);
    void deleteAllByDateBefore(Date date);
}
