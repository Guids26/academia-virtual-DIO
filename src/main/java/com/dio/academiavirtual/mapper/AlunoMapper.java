package com.dio.academiavirtual.mapper;

import com.dio.academiavirtual.dto.AlunoDto;
import com.dio.academiavirtual.model.Aluno;

public class AlunoMapper {

    public static AlunoDto toDto(Aluno aluno){
        return aluno != null ? new AlunoDto(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getBairro(), aluno.getDataDeNascimento()) : new AlunoDto();
    }

    public static Aluno toEntity(AlunoDto alunoDto){
        return alunoDto != null ? new Aluno(alunoDto.getId(), alunoDto.getNome(), alunoDto.getCpf(), alunoDto.getBairro(), alunoDto.getDataDeNascimento()) : new Aluno();
    }

}
