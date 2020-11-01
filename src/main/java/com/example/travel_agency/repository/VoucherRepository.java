package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Voucher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends CrudRepository<Voucher, String> {
}
