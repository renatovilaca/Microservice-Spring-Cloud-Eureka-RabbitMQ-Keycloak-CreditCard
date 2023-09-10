package io.github.renatovilaca.creditevaluator.application;

import io.github.renatovilaca.creditevaluator.domain.model.ClientCreditCard;
import io.github.renatovilaca.creditevaluator.domain.model.ClientInfo;
import io.github.renatovilaca.creditevaluator.domain.model.ClientStatus;
import io.github.renatovilaca.creditevaluator.infra.clients.ClientResourceClient;
import io.github.renatovilaca.creditevaluator.infra.clients.CreditCardResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditEvaluatorService {

    private final ClientResourceClient clientResourceClient;
    private final CreditCardResourceClient creditCardResourceClient;
    public ClientStatus getClientStatus(String cpf){

        ResponseEntity<ClientInfo> clientInfoResponse = clientResourceClient.getClientInfo(cpf);
        ResponseEntity<List<ClientCreditCard>> creditCardResponse = creditCardResourceClient.getCreditCardClientByCpf(cpf);

        return  ClientStatus
                .builder()
                .client(clientInfoResponse.getBody())
                .creditCards(creditCardResponse.getBody())
                .build();

    }

}
