package io.github.renatovilaca.creditevaluator.application.exception;

public class ClientInfoNotFoundException extends Exception {
    public ClientInfoNotFoundException() {
        super("The client with the requested CPF was not found!");
    }
}
