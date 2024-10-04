package com.example.RestApi.Api.Infra.Exceptions;

public class ValidacaoExcessao extends RuntimeException {

    public ValidacaoExcessao(String message) {
        super(message);
    }
}