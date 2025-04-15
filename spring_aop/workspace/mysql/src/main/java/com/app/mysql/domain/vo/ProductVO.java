package com.app.mysql.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@NoArgsConstructor
public class ProductVO extends Period{
    @EqualsAndHashCode.Include
    private Long id;
    private String productName;
    private int productPrice;
    private int productStock;

    @Builder
    public ProductVO(String createdDate, String updatedData, Long id, String productName, int productPrice, int productStock) {
        super(createdDate, updatedData);
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
}
