package io.github.renatovilaca.creditevaluator.application.exception;

public class CreditCardIssuanceErrorException extends RuntimeException {
    public CreditCardIssuanceErrorException(String message) {
        super(message);
    }
}
