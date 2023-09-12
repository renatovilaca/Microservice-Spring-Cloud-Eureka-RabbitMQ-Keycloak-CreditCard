package io.github.renatovilaca.creditevaluator.infra.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.renatovilaca.creditevaluator.domain.model.CreditCardIssuanceRequestInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCardIssuancePublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueCreditCardIssuance; //implemented bean at MessageQueueConfig

    public void requestCreditCard(CreditCardIssuanceRequestInfo data) throws JsonProcessingException {
        var json = convertToJson(data); //convert to Json format
        rabbitTemplate.convertAndSend(queueCreditCardIssuance.getName(), json); //send to queue
    }

    private String convertToJson(CreditCardIssuanceRequestInfo data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(data);
        return json;
    }

}
