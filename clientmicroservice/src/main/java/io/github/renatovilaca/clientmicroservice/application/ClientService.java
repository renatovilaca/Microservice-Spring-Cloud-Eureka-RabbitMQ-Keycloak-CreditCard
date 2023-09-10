package io.github.renatovilaca.clientmicroservice.application;

import io.github.renatovilaca.clientmicroservice.domain.Client;
import io.github.renatovilaca.clientmicroservice.infra.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> getByCPF(String cpf){
        return clientRepository.findByCpf(cpf);
    }
}
