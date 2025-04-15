package com.app.mysql.service;

import com.app.mysql.domain.dto.ProductDTO;
import com.app.mysql.domain.vo.ProductVO;

import java.util.Optional;

public interface ProductService {
//    상품 조회
    public Optional<ProductDTO> getProduct(Long id);

    public default ProductDTO toProductDTO(ProductVO productVO){
        ProductDTO productDTO = null;
        if(productVO != null){
            productDTO.setId(productVO.getId());
            productDTO.setProductName(productVO.getProductName());
            productDTO.setProductStock(productVO.getProductStock());
            productDTO.setProductPrice(productVO.getProductPrice());
            productDTO.setCreatedDate(productVO.getCreatedDate());
            productDTO.setUpdatedDate(productVO.getUpdatedData());
        }
        return productDTO;
    }
}
