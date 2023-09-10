package io.github.renatovilaca.clientmicroservice.infra.repository;

import io.github.renatovilaca.clientmicroservice.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByCpf(String cpf);
}
