package io.github.renatovilaca.creditcardmicroservice.application.representation;

import io.github.renatovilaca.creditcardmicroservice.domain.CreditCardClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardClientResponse {
    private String name;
    private String brand;
    private BigDecimal limit;

    public static CreditCardClientResponse fromModel(CreditCardClient model){
        return new CreditCardClientResponse(
                model.getCreditCard().getName(),
                model.getCreditCard().getBrand().toString(),
                model.getReleasedLimit()
        );
    }
}
