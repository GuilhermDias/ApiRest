package com.example.RestApi.Api.Domain.Usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String email;
    private String senha;
    private String telefone;
    private Role role;

    public Usuario(registarDadosUsuarios dados) {
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.senha = dados.senha();
        this.role = dados.role();
    }

    public Usuario(@NotBlank String nome, @NotBlank String sobrenome, @NotNull String telefone, @Email String email, String senhaCripto, Role role) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senhaCripto;
        this.role = role;
    }


    public void atualiza(atualizaDadosUsuarios dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.sobrenome() != null) {
            this.sobrenome = dados.sobrenome();
        }
        if(dados.email() != null) {
            this.email = dados.email();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == Role.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
