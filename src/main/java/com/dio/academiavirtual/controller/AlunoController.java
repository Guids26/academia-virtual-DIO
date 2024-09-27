package com.dio.academiavirtual.controller;

import com.dio.academiavirtual.dto.AlunoDto;
import com.dio.academiavirtual.dto.AvaliacaoFisicaDto;
import com.dio.academiavirtual.dto.MatriculaDto;
import com.dio.academiavirtual.mapper.AlunoMapper;
import com.dio.academiavirtual.mapper.AvaliacaoFisicaMapper;
import com.dio.academiavirtual.mapper.MatriculaMapper;
import com.dio.academiavirtual.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/listar")
    public List<AlunoDto> listarTodos(){
        return alunoService.listarTodos().stream().map(AlunoMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping("/matricular")
    public MatriculaDto matricularAluno(@RequestBody int alunoId){
        return MatriculaMapper.toDto(alunoService.matricular(alunoId));
    }

    @PostMapping("/avaliacao/{id}")
    public AvaliacaoFisicaDto realizarAvalizacaoFisica(@PathVariable("id") int alunoId, @RequestBody AvaliacaoFisicaDto avaliacao){
        return AvaliacaoFisicaMapper.toDto(alunoService.realizarAvaliacaoFisica(alunoId, avaliacao));
    }

    @GetMapping("/avaliacao/{id}")
    public List<AvaliacaoFisicaDto> listarAvalizacaoRealizadas(@PathVariable("id") int alunoId){
        return alunoService.listarAvalicoesDoAluno(alunoId).stream().map(AvaliacaoFisicaMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public AlunoDto cadastrarAluno(AlunoDto dto){
        return AlunoMapper.toDto(alunoService.cadastrarAluno(dto));
    }



}
