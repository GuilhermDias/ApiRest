package com.example.RestApi.Api.Repositories;

import com.example.RestApi.Api.Domain.Usuario.Usuario;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNomeAndSobrenome(String nome, String sobrenome);

    Usuario findByNome(String nome);

    UserDetails findByEmail(@Email String email);
}