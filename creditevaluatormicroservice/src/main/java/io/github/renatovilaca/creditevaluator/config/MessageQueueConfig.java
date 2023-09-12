package io.github.renatovilaca.creditevaluator.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQueueConfig {

    @Value("${mq.queues.credit-card-issuance-queue}")
    private String configQueueCreditCardIssuance;

    @Bean
    public Queue queueCreditCardIssuance(){
        return new Queue(configQueueCreditCardIssuance, true);
    }
}
