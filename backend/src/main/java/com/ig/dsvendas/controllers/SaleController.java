package com.ig.dsvendas.controllers;

import com.ig.dsvendas.dto.SaleDto;
import com.ig.dsvendas.dto.SaleSuccessDto;
import com.ig.dsvendas.dto.SaleSumDto;
import com.ig.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDto>> findAll(Pageable pageable) {
        Page<SaleDto> page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "amount-by-seller")
    public ResponseEntity<List<SaleSumDto>> amountGroupedBySeller() {
        List<SaleSumDto> list = service.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "success-by-seller")
    public ResponseEntity<List<SaleSuccessDto>> successGroupedBySeller() {
        List<SaleSuccessDto> list = service.successGroupedBySeller();
        return ResponseEntity.ok(list);
    }
}
