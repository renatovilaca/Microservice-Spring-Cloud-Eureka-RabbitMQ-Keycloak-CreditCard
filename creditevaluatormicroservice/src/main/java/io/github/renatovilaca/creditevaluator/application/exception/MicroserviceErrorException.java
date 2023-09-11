package io.github.renatovilaca.creditevaluator.application.exception;

import lombok.Getter;

public class MicroserviceErrorException extends Exception {

    @Getter
    private Integer status;

    public MicroserviceErrorException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
