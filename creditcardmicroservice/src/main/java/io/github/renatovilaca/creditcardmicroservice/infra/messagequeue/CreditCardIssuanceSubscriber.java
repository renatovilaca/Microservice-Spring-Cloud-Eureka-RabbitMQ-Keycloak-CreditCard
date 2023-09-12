package io.github.renatovilaca.creditcardmicroservice.infra.messagequeue;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.renatovilaca.creditcardmicroservice.domain.CreditCard;
import io.github.renatovilaca.creditcardmicroservice.domain.CreditCardClient;
import io.github.renatovilaca.creditcardmicroservice.domain.CreditCardIssuanceRequestInfo;
import io.github.renatovilaca.creditcardmicroservice.infra.repository.CreditCardClientRepository;
import io.github.renatovilaca.creditcardmicroservice.infra.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreditCardIssuanceSubscriber {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardClientRepository creditCardClientRepository;

    @RabbitListener(queues = "${mq.queues.credit-card-issuance-queue}")
    public void getIssuanceRequest(@Payload String payload) {

        try{
            var mapper = new ObjectMapper();
            CreditCardIssuanceRequestInfo data = mapper.readValue(payload, CreditCardIssuanceRequestInfo.class);

            CreditCard creditCard = creditCardRepository.findById(data.getCreditCardId()).orElseThrow();

            CreditCardClient creditCardClient = new CreditCardClient();
            creditCardClient.setCreditCard(creditCard);
            creditCardClient.setCpf(data.getCpf());
            creditCardClient.setReleasedLimit(data.getReleasedLimit());

            creditCardClientRepository.save(creditCardClient);

        } catch (Exception e){
            log.error(e.getMessage());
        }

    }
}
