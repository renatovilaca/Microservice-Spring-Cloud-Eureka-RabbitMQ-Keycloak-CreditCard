package io.github.renatovilaca.clientmicroservice.application;

import io.github.renatovilaca.clientmicroservice.application.representation.ClientSaveRequest;
import io.github.renatovilaca.clientmicroservice.domain.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
@Slf4j
public class ClientResource {

    private final ClientService clientService;
    @GetMapping
    public String status(){
        log.info("Getting microservice client status");
        return "OK";
    }

    @PostMapping
    public ResponseEntity saveClient(@RequestBody ClientSaveRequest request){

        Client client = request.toModel();
        clientService.save(client);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getClient(@RequestParam("cpf") String cpf){
        var client = clientService.getByCPF(cpf);

        if (client.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(client);
    }
}
