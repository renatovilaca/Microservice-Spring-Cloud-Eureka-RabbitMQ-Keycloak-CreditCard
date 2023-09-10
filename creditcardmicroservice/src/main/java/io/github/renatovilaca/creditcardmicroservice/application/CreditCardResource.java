package io.github.renatovilaca.creditcardmicroservice.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("creditcards")
@RequiredArgsConstructor
@Slf4j
public class CreditCardResource {
    @GetMapping
    public String status(){
        log.info("Getting microservice credit card status");
        return "OK";
    }
}
