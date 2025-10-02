package com.example.funcionarios.business;

import com.example.funcionarios.infrastructure.entitiys.Funcionario;
import com.example.funcionarios.infrastructure.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void salvarFuncionario(Funcionario funcionario ) {
        repository.saveAndFlush(funcionario);
    }

    public Funcionario buscarFuncionarioPorEmail(String email) {

        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado") // Se retornar esta mensagem, corresponde a esta exceção
        );
    }

    public void deletarFuncionarioPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void atualizarFuncionarioPorId(Integer id, Funcionario funcionario) {
        Funcionario funcionarioEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado"));
        Funcionario funcionarioAtualizado = Funcionario.builder()
                .email(funcionario.getEmail() != null ?
                        funcionario.getEmail() : funcionarioEntity.getEmail())
                .nome(funcionario.getNome() != null ? funcionario.getNome() :
                        funcionarioEntity.getNome())
                .id(funcionarioEntity.getId())
                .build();

        repository.saveAndFlush(funcionarioAtualizado);
    }
}

