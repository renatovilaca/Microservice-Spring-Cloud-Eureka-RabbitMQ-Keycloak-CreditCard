package io.github.renatovilaca.creditcardmicroservice.application;

import io.github.renatovilaca.creditcardmicroservice.domain.CreditCardClient;
import io.github.renatovilaca.creditcardmicroservice.infra.repository.CreditCardClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditCardClientService {

    private final CreditCardClientRepository creditCardClientRepository;

    public List<CreditCardClient> listCreditCardClientByCpf(String cpf){
        return creditCardClientRepository.findByCpf(cpf);
    }
}
