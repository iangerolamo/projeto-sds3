package com.ig.dsvendas.repositories;

import com.ig.dsvendas.dto.SaleSumDto;
import com.ig.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.ig.dsvendas.dto.SaleSumDto(obj.seller, SUM(obj.amount))" +
            "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDto> amountGroupedBySeller();
}
