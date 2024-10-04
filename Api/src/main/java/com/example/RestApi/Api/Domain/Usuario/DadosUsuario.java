package com.example.RestApi.Api.Domain.Usuario;

public record DadosUsuario(String nome, String sobrenome, String email, String telelfone) {
    public DadosUsuario(Usuario usuario) {
        this(usuario.getNome(), usuario.getSobrenome(), usuario.getEmail(), usuario.getTelefone());
    }
}