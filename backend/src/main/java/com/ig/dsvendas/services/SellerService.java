package com.ig.dsvendas.services;

import com.ig.dsvendas.dto.SellerDto;
import com.ig.dsvendas.entities.Seller;
import com.ig.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerDto> findAll() {
        List<Seller> result = repository.findAll();
        return result.stream().map(x -> new SellerDto(x)).collect(Collectors.toList());
    }
}
