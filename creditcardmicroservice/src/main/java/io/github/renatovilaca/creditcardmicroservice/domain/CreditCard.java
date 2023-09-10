package io.github.renatovilaca.creditcardmicroservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Brand brand;
    private BigDecimal income;
    private BigDecimal initialLimit;

    public CreditCard(String name, Brand brand, BigDecimal income, BigDecimal initialLimit) {
        this.name = name;
        this.brand = brand;
        this.income = income;
        this.initialLimit = initialLimit;
    }
}
