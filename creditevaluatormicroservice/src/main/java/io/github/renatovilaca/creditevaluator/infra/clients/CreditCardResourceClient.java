package io.github.renatovilaca.creditevaluator.infra.clients;

import io.github.renatovilaca.creditevaluator.domain.model.ClientCreditCard;
import io.github.renatovilaca.creditevaluator.domain.model.CreditCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "creditcard-microservice", path = "/creditcards")
public interface CreditCardResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCreditCard>> getCreditCardClientByCpf(@RequestParam("cpf") String cpf);

    @GetMapping(params = "income")
    ResponseEntity<List<CreditCard>> getCreditCardByIncome(@RequestParam("income") Long income);

}
