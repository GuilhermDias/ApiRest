package com.example.RestApi.Api.Domain.Usuario;


import jakarta.validation.constraints.NotNull;

public record exibiDadosUmUsuario(@NotNull String nome, @NotNull String sobrenome, String email, String telefone) {
}
