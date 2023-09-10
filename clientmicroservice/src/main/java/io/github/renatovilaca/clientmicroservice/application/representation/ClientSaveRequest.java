package io.github.renatovilaca.clientmicroservice.application.representation;

import io.github.renatovilaca.clientmicroservice.domain.Client;
import lombok.Data;

@Data
public class ClientSaveRequest {
    private String cpf;
    private String name;
    private Integer age;

    public Client toModel(){
        return new Client(cpf, name, age);
    }
}
