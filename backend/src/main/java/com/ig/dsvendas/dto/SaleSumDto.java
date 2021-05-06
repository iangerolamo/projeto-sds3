package com.ig.dsvendas.dto;

import com.ig.dsvendas.entities.Seller;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class SaleSumDto implements Serializable {
    private static final long serialVersionUID = 1L;


    private String sellerName;
    private Double sum;

    public SaleSumDto(Seller seller, Double sum) {
        this.sellerName = seller.getName();
        this.sum = sum;
    }
}
