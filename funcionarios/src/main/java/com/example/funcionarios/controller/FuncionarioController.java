package com.example.funcionarios.controller;

import com.example.funcionarios.business.FuncionarioService;
import com.example.funcionarios.infrastructure.entitiys.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Anotação que diz que o controller é de padrão REST
@RequestMapping("/funcionarios") // Padrão de requisições no localhost
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5500")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping // Anotação para gravar dados
    public ResponseEntity<Void> salvarFuncionario(@RequestBody Funcionario funcionario) {

        funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Funcionario> buscarFuncionarioPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(funcionarioService.buscarFuncionarioPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarFuncionarioPorNomeId(@RequestParam String nome) {
        funcionarioService.deletarFuncionarioPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping // Atualiza todos os campos do banco de dados
    public ResponseEntity<Void> atualizarFuncionarioPorId(@RequestParam Integer id, @RequestBody Funcionario funcionario) {
        funcionarioService.atualizarFuncionarioPorId(id, funcionario);
        return ResponseEntity.ok().build();
    }
}
