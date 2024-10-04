package com.example.RestApi.Api.Controller;

import com.example.RestApi.Api.Domain.Modelo.*;
import com.example.RestApi.Api.Repositories.ModeloRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRepository;

    @PostMapping("/modelos/registro")
    @Transactional
    public ResponseEntity registro(@RequestBody @Valid registroDadosModelo dados){
        var modelo = new Modelo(dados);
        modeloRepository.save(modelo);
        return ResponseEntity.ok().body(new DadosModelos(modelo));
    }

    @GetMapping("/modelos/todos")
    public ResponseEntity<Page<exibirDadosModelos>> exibeTodosModelos(@PageableDefault(size = 5, sort = {"marca"}) Pageable pageable){
        var page = modeloRepository.findAll(pageable).map(exibirDadosModelos::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/modelos/exibe")
    public ResponseEntity exibeModelo(@RequestBody @Valid exibeDadosUmModelo dados){
        var modelo = modeloRepository.findByNomeAndAnofabricacao(dados.nome(), dados.ano_fabricacao());
        return ResponseEntity.ok(new DadosModelos(modelo));
    }

    @PutMapping("/modelos/atualizar")
    @Transactional
    public ResponseEntity atualizaModelos(@RequestBody @Valid atualizaDadosModelos dados){
        var modelo = modeloRepository.findByNome(dados.nome());
        modelo.atualizaModelo(dados);
        return ResponseEntity.ok(new DadosModelos(modelo));
    }

    @DeleteMapping("/modelos/deletar")
    @Transactional
    public ResponseEntity deletaModelos(@RequestBody @Valid deletarDadosModelos dados) {
        modeloRepository.deleteByNomeAndAnofabricacao(dados.nome(), dados.ano_fabricacao());
        return ResponseEntity.noContent().build();
    }
}