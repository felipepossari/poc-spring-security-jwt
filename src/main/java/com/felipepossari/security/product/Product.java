package com.felipepossari.security.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Product {
    private String id;
    private String name;
    private BigDecimal price;
}
