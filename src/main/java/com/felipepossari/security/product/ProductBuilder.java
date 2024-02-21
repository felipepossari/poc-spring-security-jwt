package com.felipepossari.security.product;

import com.felipepossari.security.product.api.model.ProductRequest;
import com.felipepossari.security.product.api.model.ProductResponse;
import com.felipepossari.security.product.repository.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductBuilder {

    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
    }

    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public Product toProduct(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }

    public ProductEntity toProduct(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
