package io.github.renatovilaca.creditcardmicroservice.infra.repository;

import io.github.renatovilaca.creditcardmicroservice.domain.CreditCardClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardClientRepository extends JpaRepository<CreditCardClient, Long> {
    List<CreditCardClient> findByCpf(String cpf);
}
