package com.example.RestApi.Api.Domain.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record registarDadosUsuarios(@NotBlank String nome, @NotBlank String sobrenome, @Email String email, @NotNull String senha, @NotNull String telefone, Role role) {
}
