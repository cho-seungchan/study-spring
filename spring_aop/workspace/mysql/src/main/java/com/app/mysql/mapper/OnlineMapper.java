package com.app.mysql.mapper;

import com.app.mysql.domain.dto.Pagination;
import com.app.mysql.domain.dto.ProductOnlineDTO;
import com.app.mysql.domain.vo.OnlineVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OnlineMapper {
//    상품 추가
    public void insert(OnlineVO onlineVO);

//    상품 수정
    public void update(OnlineVO onlineVO);

//    상품 조회
    public Optional<ProductOnlineDTO> selectDtoById(Long id);

//    상품 목록
    public List<ProductOnlineDTO> selectAll(Pagination pagination);
}













