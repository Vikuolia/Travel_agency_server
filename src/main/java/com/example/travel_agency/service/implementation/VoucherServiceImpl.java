package com.example.travel_agency.service.implementation;


import com.example.travel_agency.entity.Voucher;
import com.example.travel_agency.repository.VoucherRepository;
import com.example.travel_agency.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public Voucher addVoucher(Voucher newVoucher) {
        return voucherRepository.save(newVoucher);
    }

    @Override
    public List<Voucher> getAll() {
        return (List<Voucher>) voucherRepository.findAll();
    }

    @Override
    public List<Voucher> getByName(String name) {
        return voucherRepository.findByName(name);
    }

    @Override
    public List<Voucher> getAvailable() {
        return voucherRepository.findByDateAfter(new Date());
    }

    @Override
    public void deleteById(String id) {
        voucherRepository.deleteById(id);
    }

    @Override
    public void deleteNotAvailable() {
        voucherRepository.deleteAllByDateBefore(new Date());
    }
}
