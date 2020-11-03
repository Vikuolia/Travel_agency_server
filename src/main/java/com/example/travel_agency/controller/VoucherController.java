package com.example.travel_agency.controller;

import com.example.travel_agency.entity.Voucher;
import com.example.travel_agency.service.VoucherService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
@AllArgsConstructor
@NoArgsConstructor
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @PostMapping
    public Voucher addVoucher(@RequestBody Voucher voucher){
        return voucherService.addVoucher(voucher);
    }

    @GetMapping
    public List<Voucher> getAllVouchers(){
        return voucherService.getAll();
    }

    @GetMapping
    public List<Voucher> getAvailableVouchers(){ return voucherService.getAvailable(); }

    @GetMapping("{voucherId}")
    public Voucher getVouchersById(@PathVariable String voucherId)throws NotFoundException {
        return voucherService.getById(voucherId);
    }

    @DeleteMapping("{voucherId}")
    public ResponseEntity<Void> deleteVoucherById(@PathVariable String voucherId){
        voucherService.deleteById(voucherId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNotAvailableVouchers(){
        voucherService.deleteNotAvailable();
        return ResponseEntity.noContent().build();
    }
}
