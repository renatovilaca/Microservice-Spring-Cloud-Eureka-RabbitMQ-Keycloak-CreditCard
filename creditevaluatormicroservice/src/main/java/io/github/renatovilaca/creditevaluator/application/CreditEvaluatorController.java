package io.github.renatovilaca.creditevaluator.application;

import io.github.renatovilaca.creditevaluator.application.exception.ClientInfoNotFoundException;
import io.github.renatovilaca.creditevaluator.application.exception.MicroserviceErrorException;
import io.github.renatovilaca.creditevaluator.domain.model.ClientStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("creditevaluator")
@RequiredArgsConstructor
@Slf4j
public class CreditEvaluatorController {

    private final CreditEvaluatorService creditEvaluatorService;

    @GetMapping
    public String status(){
        log.info("Getting microservice credit evaluator status");
        return "OK";
    }

    @GetMapping(value = "client-status", params = "cpf")
    public ResponseEntity getClientStatus(@RequestParam("cpf") String cpf){

        try {
            ClientStatus clientStatus = creditEvaluatorService.getClientStatus(cpf);
            return ResponseEntity.ok(clientStatus);
        } catch (ClientInfoNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (MicroserviceErrorException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

}
