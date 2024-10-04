package com.example.RestApi.Api.Domain.Usuario;

import jakarta.validation.constraints.NotNull;

public record atualizaDadosUsuarios(@NotNull String nome, String sobrenome, String email, String telefone) {
}
