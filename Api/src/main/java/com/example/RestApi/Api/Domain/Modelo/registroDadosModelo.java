package com.example.RestApi.Api.Domain.Modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record registroDadosModelo(@NotBlank String marca,
                                  @NotBlank String nome,
                                  @NotNull Double tabela_fipe,
                                  @NotNull Integer ano_fabricacao,
                                  @NotNull Tipo tipo,
                                  String descricao) {
}
