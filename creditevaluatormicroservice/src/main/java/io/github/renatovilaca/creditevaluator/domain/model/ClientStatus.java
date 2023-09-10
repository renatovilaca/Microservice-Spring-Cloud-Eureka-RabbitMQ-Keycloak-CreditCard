package io.github.renatovilaca.creditevaluator.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientStatus {

    private ClientInfo client;
    private List<ClientCreditCard> creditCards;

}
