package com.example.travel_agency.service;

import com.example.travel_agency.entity.Voucher;
import javassist.NotFoundException;

import java.util.List;

public interface VoucherService {

    Voucher addVoucher(Voucher newVoucher);

    List<Voucher> getAll();

    Voucher getById(String id) throws NotFoundException;

    List<Voucher> getAvailable();

    void deleteById(String id);

    void deleteNotAvailable();
}
