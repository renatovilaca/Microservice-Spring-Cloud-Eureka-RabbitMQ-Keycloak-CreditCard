package io.github.renatovilaca.creditevaluator.application;

import feign.FeignException;
import io.github.renatovilaca.creditevaluator.application.exception.ClientInfoNotFoundException;
import io.github.renatovilaca.creditevaluator.application.exception.MicroserviceErrorException;
import io.github.renatovilaca.creditevaluator.domain.model.*;
import io.github.renatovilaca.creditevaluator.infra.clients.ClientResourceClient;
import io.github.renatovilaca.creditevaluator.infra.clients.CreditCardResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditEvaluatorService {

    private final ClientResourceClient clientResourceClient;
    private final CreditCardResourceClient creditCardResourceClient;
    public ClientStatus getClientStatus(String cpf) throws ClientInfoNotFoundException, MicroserviceErrorException {

        try {
            ResponseEntity<ClientInfo> clientInfoResponse = clientResourceClient.getClientInfo(cpf);
            ResponseEntity<List<ClientCreditCard>> creditCardResponse = creditCardResourceClient.getCreditCardClientByCpf(cpf);

            return  ClientStatus
                    .builder()
                    .client(clientInfoResponse.getBody())
                    .creditCards(creditCardResponse.getBody())
                    .build();

        } catch (FeignException.FeignClientException e) {
            int status = e.status();

            if (HttpStatus.NOT_FOUND.value() == status)
                throw new ClientInfoNotFoundException();

            throw new MicroserviceErrorException(e.getMessage(), status);
        }

    }

    public ClientEvaluationResponse getEvaluation(String cpf, Long income) throws ClientInfoNotFoundException, MicroserviceErrorException {

        try {
            ResponseEntity<ClientInfo> clientInfoResponse = clientResourceClient.getClientInfo(cpf);
            ResponseEntity<List<CreditCard>> creditCardResponse = creditCardResourceClient.getCreditCardByIncome(income);

            List<CreditCard> creditCards = creditCardResponse.getBody();

            var listApprovedCreditCards = creditCards.stream().map(creditCard -> {

                ClientInfo clientInfo = clientInfoResponse.getBody();

                BigDecimal initialLimit = creditCard.getInitialLimit();
                BigDecimal ageBD = BigDecimal.valueOf(clientInfo.getAge());
                var factor = ageBD.divide(BigDecimal.valueOf(10));
                BigDecimal releasedLimit = factor.multiply(initialLimit);

                ApprovedCreditCard approvedCreditCard = new ApprovedCreditCard();
                approvedCreditCard.setName(creditCard.getName());
                approvedCreditCard.setBrand(creditCard.getBrand());
                approvedCreditCard.setReleasedLimit(releasedLimit);

                return approvedCreditCard;
            }).collect(Collectors.toList());

            return new ClientEvaluationResponse(listApprovedCreditCards);

        } catch (FeignException.FeignClientException e) {
            int status = e.status();

            if (HttpStatus.NOT_FOUND.value() == status)
                throw new ClientInfoNotFoundException();

            throw new MicroserviceErrorException(e.getMessage(), status);
        }
    }

}
