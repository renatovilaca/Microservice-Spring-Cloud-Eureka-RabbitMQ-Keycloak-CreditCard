package io.github.renatovilaca.creditevaluator.application;

import io.github.renatovilaca.creditevaluator.domain.model.ClientInfo;
import io.github.renatovilaca.creditevaluator.domain.model.ClientStatus;
import io.github.renatovilaca.creditevaluator.infra.clients.ClientResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditEvaluatorService {

    private  final ClientResourceClient clientResourceClient;
    public ClientStatus getClientStatus(String cpf){

        ResponseEntity<ClientInfo> clientInfoResponse = clientResourceClient.getClientInfo(cpf);

        return  ClientStatus
                .builder()
                .client(clientInfoResponse.getBody())
                .build();

    }

}
