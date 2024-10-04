package com.example.RestApi.Api.Domain.Usuario;

public record exibirTodosUsuarios(String nome, String sobrenome, String email, String telefone) {
    public exibirTodosUsuarios(Usuario usuario){
        this(usuario.getNome(), usuario.getSobrenome(), usuario.getEmail(), usuario.getTelefone());
    }
}
