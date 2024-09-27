package com.dio.academiavirtual.repository;

import com.dio.academiavirtual.model.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Integer> {
    List<AvaliacaoFisica> findByAlunoId(int alunoId);
}
