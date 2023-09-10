package io.github.renatovilaca.creditevaluator.infra.clients;

import io.github.renatovilaca.creditevaluator.domain.model.ClientInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "client-microservice", path = "/clients")
public interface ClientResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<ClientInfo> getClientInfo(@RequestParam("cpf") String cpf);

}
