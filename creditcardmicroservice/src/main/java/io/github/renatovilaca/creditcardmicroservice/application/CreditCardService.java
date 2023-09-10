package io.github.renatovilaca.creditcardmicroservice.application;

import io.github.renatovilaca.creditcardmicroservice.domain.CreditCard;
import io.github.renatovilaca.creditcardmicroservice.infra.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    @Transactional
    public CreditCard save(CreditCard creditCard){
        return creditCardRepository.save(creditCard);
    }

    public List<CreditCard> getCreditCardByIncome(Long income){
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return creditCardRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
