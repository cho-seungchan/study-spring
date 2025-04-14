package com.app.mysql.mapper;

import com.app.mysql.domain.dto.ProductOnlineDTO;
import com.app.mysql.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface ProductMapper {
//    상품 추가
    public void insert(ProductVO productVO);

//    상품 수정
    public void update(ProductVO productVO);

//    상품 삭제
    public void delete(Long id);

//    상품 조회
    public Optional<ProductVO> selectVoById(Long id);

//    상품 전체 개수
    public int selectTotal();
}














