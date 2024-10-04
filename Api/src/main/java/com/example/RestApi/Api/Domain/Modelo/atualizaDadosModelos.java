package com.example.RestApi.Api.Domain.Modelo;

import jakarta.validation.constraints.NotNull;

public record atualizaDadosModelos(String marca, @NotNull String nome, double tabela_fipe, Integer ano_fabricacao, String descricao) {
}
