package io.github.renatovilaca.creditcardmicroservice.application;

import io.github.renatovilaca.creditcardmicroservice.application.representation.CreditCardClientResponse;
import io.github.renatovilaca.creditcardmicroservice.application.representation.CreditCardSaveRequest;
import io.github.renatovilaca.creditcardmicroservice.domain.CreditCard;
import io.github.renatovilaca.creditcardmicroservice.domain.CreditCardClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("creditcards")
@RequiredArgsConstructor
@Slf4j
public class CreditCardResource {

    private final CreditCardService creditCardService;
    private final CreditCardClientService creditCardClientService;
    @GetMapping
    public String status(){
        log.info("Getting microservice credit card status");
        return "OK";
    }

    @PostMapping
    public ResponseEntity saveCreditCard(@RequestBody CreditCardSaveRequest request){
        CreditCard creditCard = request.toModel();
        creditCardService.save(creditCard);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<CreditCard>> getCreditCardByIncome(@RequestParam("income") Long income) {
        List<CreditCard> list = creditCardService.getCreditCardByIncome(income);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CreditCardClientResponse>> getCreditCardClientByCpf(@RequestParam("cpf") String cpf){
        List<CreditCardClient> list = creditCardClientService.listCreditCardClientByCpf(cpf);

        List<CreditCardClientResponse> resultList = list.stream()
                .map(CreditCardClientResponse::fromModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resultList);
    }


}
