package io.github.renatovilaca.creditcardmicroservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class CreditCardClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;
    private BigDecimal releasedLimit;

}
