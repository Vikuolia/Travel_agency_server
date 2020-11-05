package com.example.travel_agency.service.implementation;


import com.example.travel_agency.entity.Voucher;
import com.example.travel_agency.repository.VoucherRepository;
import com.example.travel_agency.service.VoucherService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;

    @Autowired
    public VoucherServiceImpl(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @Override
    public Voucher addVoucher(Voucher newVoucher) {
        return voucherRepository.save(newVoucher);
    }

    @Override
    public List<Voucher> getAll() {
        return (List<Voucher>) voucherRepository.findAll();
    }

    @Override
    public Voucher getById(String id) throws NotFoundException {
        Optional<Voucher> optionalVoucher = voucherRepository.findById(id);
        if(optionalVoucher.isPresent()) return voucherRepository.findById(id).get();
        else throw new NotFoundException(String.format("Voucher with id: %s does not exist", id));
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
