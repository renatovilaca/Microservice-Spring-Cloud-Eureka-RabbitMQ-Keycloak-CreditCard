package io.github.renatovilaca.creditevaluator.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditCardIssuanceRequestInfo {
    private Long creditCardId;
    private String cpf;
    private String address;
    private BigDecimal releasedLimit;
}
