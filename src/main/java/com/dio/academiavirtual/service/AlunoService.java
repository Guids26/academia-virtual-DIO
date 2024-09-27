package com.dio.academiavirtual.service;

import com.dio.academiavirtual.dto.AlunoDto;
import com.dio.academiavirtual.dto.AvaliacaoFisicaDto;
import com.dio.academiavirtual.exception.custom.AlunoNotFoundException;
import com.dio.academiavirtual.exception.custom.CpfConflictException;
import com.dio.academiavirtual.mapper.AlunoMapper;
import com.dio.academiavirtual.model.Aluno;
import com.dio.academiavirtual.model.AvaliacaoFisica;
import com.dio.academiavirtual.model.Matricula;
import com.dio.academiavirtual.repository.AlunoRepository;
import com.dio.academiavirtual.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public Aluno cadastrarAluno(AlunoDto dto){
        Aluno aluno = new Aluno();
        if(alunoRepository.findFirstByCpf(dto.getCpf()).isPresent()){
            throw new CpfConflictException("já existe um aluno com o cpf informado");
        }
        if(dto != null){
            aluno.setNome(dto.getNome());
            aluno.setCpf(dto.getCpf());
            aluno.setBairro(dto.getBairro());
            aluno.setDataDeNascimento(dto.getDataDeNascimento());
            alunoRepository.save(aluno);
        }
        return aluno;
    }

    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }

    public List<AvaliacaoFisica> listarAvalicoesDoAluno(int alunoId){
        return avaliacaoFisicaRepository.findByAlunoId(alunoId);
    }

    public Matricula matricular(int alunoId){
        Optional<Aluno> aluno = alunoRepository.findById(alunoId);
        if(aluno.isPresent()){
            Matricula novaMatricula = new Matricula();
            novaMatricula.setAluno(aluno.get());
            novaMatricula.setDataDaMatricula(LocalDateTime.now());
            return novaMatricula;
        }else{
            throw new AlunoNotFoundException("id informado do aluno não existe");
        }
    }

    public AvaliacaoFisica realizarAvaliacaoFisica(int alunoId, AvaliacaoFisicaDto dto){
        Optional<Aluno> aluno = alunoRepository.findById(alunoId);
        if(aluno.isPresent()){
            AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
            avaliacaoFisica.setAluno(aluno.get());
            avaliacaoFisica.setDataDaAvaliacao(LocalDateTime.now());
            avaliacaoFisica.setPeso(dto.getPeso());
            avaliacaoFisica.setAltura(dto.getAltura());
            avaliacaoFisica = avaliacaoFisicaRepository.save(avaliacaoFisica);
            return avaliacaoFisica;
        }else{
            throw new AlunoNotFoundException("id informado do aluno não existe");
        }
    }
}