package com.app.mysql.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductOnlineDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String productName;
    private int productPrice;
    private int productStock;
    private String marketName;
    private String createdDate;
    private String updatedDate;
}
