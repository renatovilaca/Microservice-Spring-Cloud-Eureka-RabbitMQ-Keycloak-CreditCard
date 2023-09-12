package io.github.renatovilaca.creditcardmicroservice.infra.messagequeue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CreditCardIssuanceSubscriber {

    @RabbitListener(queues = "${mq.queues.credit-card-issuance}")
    public void getIssuanceRequest(@Payload String payload){
        System.out.println(payload);
    }
}
