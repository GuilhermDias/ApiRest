package com.example.RestApi.Api.Repositories;

import com.example.RestApi.Api.Domain.Modelo.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    Modelo findByNome(String nome);

    @Modifying
    @Query("delete from Modelo m where m.nome = :nome and m.ano_fabricacao = :ano_fabricacao")
    void deleteByNomeAndAnofabricacao(@Param("nome") String nome, @Param("ano_fabricacao") Integer ano_fabricacao);

    @Query("select m from Modelo m where m.nome = :nome and m.ano_fabricacao = :ano_fabricacao")
    Modelo findByNomeAndAnofabricacao(@Param("nome") String nome, @Param("ano_fabricacao") Integer ano_fabricacao);

}
