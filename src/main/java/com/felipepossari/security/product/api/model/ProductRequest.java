package com.felipepossari.security.product.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductRequest {
    private String name;
    private BigDecimal price;
}
