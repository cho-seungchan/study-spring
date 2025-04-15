package com.app.mysql.repository;

import com.app.mysql.domain.vo.ProductVO;
import com.app.mysql.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

//    상품 조회
    public Optional<ProductVO> findVoById(Long id){
        return productMapper.selectVoById(id);
    }
}















