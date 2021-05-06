package com.ig.dsvendas.dto;

import com.ig.dsvendas.entities.Seller;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class SaleSuccessDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sellerName;
    private Long visited;
    private Long deals;

    public SaleSuccessDto(Seller seller, Long visited, Long deals) {
        sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }
}
