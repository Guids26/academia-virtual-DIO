package com.dio.academiavirtual.repository;

import com.dio.academiavirtual.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Optional<Aluno> findFirstByCpf(String cpf);
}
