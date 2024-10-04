package com.example.RestApi.Api.Controller;

import com.example.RestApi.Api.Domain.Usuario.LoginResponseDTO;
import com.example.RestApi.Api.Domain.Usuario.Usuario;
import com.example.RestApi.Api.Domain.Usuario.autenticacaoDTO;
import com.example.RestApi.Api.Infra.Security.TokenService;
import com.example.RestApi.Api.Repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    @Transactional
    public ResponseEntity login(@RequestBody @Valid autenticacaoDTO dados){
        var senhaUsuario = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var auth = this.authenticationManager.authenticate(senhaUsuario);
        var token = tokenService.geracaoToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}

