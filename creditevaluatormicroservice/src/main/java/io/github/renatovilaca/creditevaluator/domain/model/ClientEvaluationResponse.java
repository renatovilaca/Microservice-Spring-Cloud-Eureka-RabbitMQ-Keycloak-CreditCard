package io.github.renatovilaca.creditevaluator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClientEvaluationResponse {
    private List<ApprovedCreditCard> creditCards;
}

