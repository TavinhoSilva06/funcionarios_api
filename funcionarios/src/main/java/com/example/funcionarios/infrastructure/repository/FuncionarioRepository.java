package com.example.funcionarios.infrastructure.repository;

import com.example.funcionarios.infrastructure.entitiys.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    Optional<Funcionario> findByEmail(String email); // Quando se usa o Optional, é obrigação criar uma exceção caso a condição não exista

    @Transactional // Anotação feita para caso der um erro, ele não deletar a conta.
    void deleteByEmail(String email);
}
