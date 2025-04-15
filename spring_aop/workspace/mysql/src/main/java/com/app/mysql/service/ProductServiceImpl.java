package com.app.mysql.service;

import com.app.mysql.domain.dto.ProductDTO;
import com.app.mysql.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Override
    public Optional<ProductDTO> getProduct(Long id) {
        return Optional.ofNullable(
                toProductDTO(productDAO.findVoById(id)
                        .orElseThrow(RuntimeException::new)));
    }
}
