package com.felipepossari.security.product;

import com.felipepossari.security.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductBuilder builder;

    public List<Product> getAll() {
        return productRepository.findAll().stream().map(builder::toProduct).toList();
    }

    public Product create(Product product) {
        var productCreated = productRepository.save(builder.toProduct(product));
        return builder.toProduct(productCreated);
    }
}
