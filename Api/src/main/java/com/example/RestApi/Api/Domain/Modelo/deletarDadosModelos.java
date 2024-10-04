package com.example.RestApi.Api.Domain.Modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record deletarDadosModelos(@NotBlank String nome, @NotNull Integer ano_fabricacao) {
}
