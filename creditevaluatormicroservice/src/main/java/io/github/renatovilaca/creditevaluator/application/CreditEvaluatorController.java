package io.github.renatovilaca.creditevaluator.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("creditevaluator")
@Slf4j
public class CreditEvaluatorController {

    @GetMapping
    public String status(){
        log.info("Getting microservice credit evaluator status");
        return "OK";
    }

}
