package io.github.renatovilaca.creditevaluator.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditCard {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal initialLimit;
}
