package com.app.mysql.domain.dto;

import com.app.mysql.domain.vo.ProductVO;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ProductDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String productName;
    private int productPrice;
    private int productStock;
    private String createdDate;
    private String updatedDate;

    public ProductVO toVO(){
        return ProductVO.builder()
                .id(id)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .createdDate(createdDate)
                .updatedData(updatedDate)
                .build();
    }
}
