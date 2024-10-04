package com.example.RestApi.Api.Domain.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modelo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Modelo{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String nome;
    private double tabela_fipe;
    private Integer ano_fabricacao;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private String descricao;


    public Modelo(registroDadosModelo dados) {
        this.marca = dados.marca();
        this.nome = dados.nome();
        this.tabela_fipe = dados.tabela_fipe();
        this.ano_fabricacao = dados.ano_fabricacao();
        this.tipo = dados.tipo();
        this.descricao = dados.descricao();
    }

    public void atualizaModelo(atualizaDadosModelos dadosModelos) {
        if(dadosModelos.nome() != null){
            this.nome = dadosModelos.nome();
        }
        if(dadosModelos.tabela_fipe() != 0){
            this.tabela_fipe = dadosModelos.tabela_fipe();
        }
        if(dadosModelos.ano_fabricacao() != null){
            this.ano_fabricacao = dadosModelos.ano_fabricacao();
        }
        if(dadosModelos.descricao() != null){
            this.descricao = dadosModelos.descricao();
        }
    }
}
