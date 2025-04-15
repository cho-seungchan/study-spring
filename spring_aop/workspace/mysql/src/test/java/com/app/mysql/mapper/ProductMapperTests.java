package com.app.mysql.mapper;

import com.app.mysql.domain.dto.OnlineDTO;
import com.app.mysql.domain.dto.Pagination;
import com.app.mysql.domain.dto.ProductDTO;
import com.app.mysql.domain.dto.ProductOnlineDTO;
import com.app.mysql.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class ProductMapperTests {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OnlineMapper onlineMapper;

    @Test
    public void testInsert(){
        ProductOnlineDTO productOnlineDTO = new ProductOnlineDTO();
        productOnlineDTO.setProductName("세탁기");
        productOnlineDTO.setProductPrice(182000);
        productOnlineDTO.setProductStock(84);
        productOnlineDTO.setMarketName("삼성전자");

        ProductDTO productDTO = new ProductDTO();
        OnlineDTO onlineDTO = new OnlineDTO();

        ProductVO productVO = null;

        productDTO.setProductName(productOnlineDTO.getProductName());
        productDTO.setProductPrice(productOnlineDTO.getProductPrice());
        productDTO.setProductStock(productOnlineDTO.getProductStock());
        onlineDTO.setMarketName(productOnlineDTO.getMarketName());

        productVO = productDTO.toVO();

        productMapper.insert(productVO);
        onlineDTO.setId(productVO.getId());

        log.info("id: {}", onlineDTO.getId());

        onlineMapper.insert(onlineDTO.toVO());
    }

    @Test
    public void testSelectById(){
//        Optional<ProductVO> foundProduct = productMapper.selectVoById(2L);
//        ProductVO productVO = foundProduct.orElseThrow(RuntimeException::new);
//        log.info("{}", productVO.toString());

        Optional<ProductOnlineDTO> foundProductOnline = onlineMapper.selectDtoById(2L);
        ProductOnlineDTO productOnlineDTO = foundProductOnline.orElseThrow(RuntimeException::new);
        log.info("{}", productOnlineDTO.toString());
    }

    @Test
    public void testUpdate(){
        Optional<ProductOnlineDTO> foundProductOnline = onlineMapper.selectDtoById(2L);
        ProductOnlineDTO productOnlineDTO = foundProductOnline.orElseThrow(RuntimeException::new);
        ProductDTO productDTO = new ProductDTO();
        OnlineDTO onlineDTO = new OnlineDTO();

        productOnlineDTO.setProductName("칫솔");
        productOnlineDTO.setMarketName("G마켓");

        productDTO.setProductName(productOnlineDTO.getProductName());
        productDTO.setId(productOnlineDTO.getId());

        productMapper.update(productDTO.toVO());

        onlineDTO.setMarketName(productOnlineDTO.getMarketName());
        onlineDTO.setId(productOnlineDTO.getId());

        onlineMapper.update(onlineDTO.toVO());
    }

    @Test
    public void testDelete(){
        productMapper.delete(2L);
    }

    @Test
    public void testSelectAll(){
        Pagination pagination = new Pagination();
        pagination.setPage(2);
        pagination.create(productMapper.selectTotal());
        log.info("{}", pagination.toString());

        List<ProductOnlineDTO> products = onlineMapper.selectAll(pagination);
        products.stream().map(ProductOnlineDTO::toString).forEach(log::info);
        assertThat(products).hasSize(2);
    }
}












