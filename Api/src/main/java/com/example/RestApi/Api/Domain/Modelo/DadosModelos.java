package com.example.RestApi.Api.Domain.Modelo;

public record DadosModelos(String marca, String nome, double tabela_fipe, Integer ano_fabricacao, Tipo tipo, String descricao) {
    public DadosModelos(Modelo modelo){
        this(modelo.getMarca(), modelo.getNome(), modelo.getTabela_fipe(), modelo.getAno_fabricacao(), modelo.getTipo(), modelo.getDescricao());
    }
}
