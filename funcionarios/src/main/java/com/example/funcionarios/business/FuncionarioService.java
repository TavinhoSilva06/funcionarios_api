package com.example.funcionarios.business;

import com.example.funcionarios.infrastructure.entitiys.Funcionario;
import com.example.funcionarios.infrastructure.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void salvarFuncionario(Funcionario funcionario) {
        repository.saveAndFlush(funcionario);
    }

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Funcionario buscarFuncionarioPorNome(String nome) {
        return repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Nome não encontrado"));
    }

    public void deletarFuncionarioPorId(Integer id) {
        repository.deleteById(id);
    }

    // Método que serve para atualizar algum campo da linha sem interferir nos outros campos
    public void atualizarFuncionarioPorId(Integer id, Funcionario funcionario) {
        Funcionario funcionarioEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Funcionario funcionarioAtualizado = Funcionario.builder()
                .id(funcionarioEntity.getId())
                .nome(funcionario.getNome() != null ? funcionario.getNome() : funcionarioEntity.getNome())
                .profissao(funcionario.getProfissao() != null ? funcionario.getProfissao() : funcionarioEntity.getProfissao())
                .modelo(funcionario.getModelo() != null ? funcionario.getModelo() : funcionarioEntity.getModelo())
                .salario(funcionario.getSalario() != null ? funcionario.getSalario() : funcionarioEntity.getSalario())
                .build();

        repository.saveAndFlush(funcionarioAtualizado);
    }
}
