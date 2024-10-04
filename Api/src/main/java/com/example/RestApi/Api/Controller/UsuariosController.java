package com.example.RestApi.Api.Controller;

import com.example.RestApi.Api.Domain.Usuario.*;
import com.example.RestApi.Api.Repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registro")
    @Transactional
    public ResponseEntity registarUsuario(@RequestBody @Valid registarDadosUsuarios dados){
        if(this.usuarioRepository.findByEmail(dados.email()) != null) return ResponseEntity.badRequest().build();
        String senhaCripto = new BCryptPasswordEncoder().encode(dados.senha());
        Usuario usuario = new Usuario(dados.nome(), dados.sobrenome(), dados.telefone(), dados.email(), senhaCripto, dados.role());
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/exibir")
    public ResponseEntity<Page<exibirTodosUsuarios>> exibirUsuarios(@PageableDefault(size = 9, sort = "nome") Pageable pageable){
        var page = usuarioRepository.findAll(pageable).map(exibirTodosUsuarios::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/exibir/usuario")
    public ResponseEntity exibiUmUsuario(@RequestBody @Valid exibiDadosUmUsuario dados){
        var usuario = usuarioRepository.findByNomeAndSobrenome(dados.nome(), dados.sobrenome());
        return ResponseEntity.ok(new DadosUsuario(usuario));
    }

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity atualizaUsuario(@RequestBody @Valid atualizaDadosUsuarios dados){
        var usuario = usuarioRepository.findByNome(dados.nome());
        usuario.atualiza(dados);
        return ResponseEntity.ok(new DadosUsuario(usuario));
    }
}