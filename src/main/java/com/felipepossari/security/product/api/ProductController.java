package com.felipepossari.security.product.api;

import com.felipepossari.security.product.ProductBuilder;
import com.felipepossari.security.product.ProductService;
import com.felipepossari.security.product.api.model.ProductRequest;
import com.felipepossari.security.product.api.model.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService service;
    private final ProductBuilder builder;

    public ProductController(ProductService service, ProductBuilder builder) {
        this.service = service;
        this.builder = builder;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        var products = service.getAll();
        return ResponseEntity.ok(products.stream().map(builder::toResponse).toList());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        var product = service.create(builder.toProduct(request));
        return ResponseEntity.ok(builder.toResponse(product));
    }
}
