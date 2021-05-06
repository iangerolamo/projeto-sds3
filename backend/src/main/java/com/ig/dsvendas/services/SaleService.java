package com.ig.dsvendas.services;

import com.ig.dsvendas.dto.SaleDto;
import com.ig.dsvendas.dto.SaleSuccessDto;
import com.ig.dsvendas.dto.SaleSumDto;
import com.ig.dsvendas.entities.Sale;
import com.ig.dsvendas.repositories.SaleRepository;
import com.ig.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDto> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(x -> new SaleDto(x));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDto> amountGroupedBySeller() {
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDto> successGroupedBySeller() {
        return repository.successGroupedBySeller();
    }
}
