package com.example.travel_agency.service;

import com.example.travel_agency.entity.Voucher;

import java.util.List;

public interface VoucherService {

    Voucher addVoucher(Voucher newVoucher);

    List<Voucher> getAll();

    List<Voucher> getByName(String name);

    List<Voucher> getAvailable();

    void deleteById(String id);

    void deleteNotAvailable();
}
