package com.example.RestApi.Api.Infra.Exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class TryErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tryErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tryErro400(MethodArgumentNotValidException e){
        var erro = e.getFieldError();
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity tryErro403(AccessDeniedException e) {
        return ResponseEntity.badRequest().body("Usuario não tem acesso a este recurso");
    }

    private record dadosErroValidacao(String campo, String mensagem){
        public dadosErroValidacao(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
