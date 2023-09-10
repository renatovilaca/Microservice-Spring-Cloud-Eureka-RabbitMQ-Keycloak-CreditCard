package io.github.renatovilaca.creditcardmicroservice.application.representation;

import io.github.renatovilaca.creditcardmicroservice.domain.Brand;
import io.github.renatovilaca.creditcardmicroservice.domain.CreditCard;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditCardSaveRequest {

    private String name;
    private Brand brand;
    private BigDecimal income;
    private BigDecimal initialLimit;

    public CreditCard toModel(){
        return new CreditCard(name, brand, income, initialLimit);
    }
}
