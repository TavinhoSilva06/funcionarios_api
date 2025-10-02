package com.example.funcionarios.controller;

import com.example.funcionarios.business.FuncionarioService;
import com.example.funcionarios.infrastructure.entitiys.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Anotação que diz que o controller é de padrão REST
@RequestMapping("/usuario") // Padrão de requisições no localhost
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping // Anotação para gravar dados
    public ResponseEntity<Void> salvarFuncionario(@RequestBody Funcionario funcionario) {

        funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Funcionario> buscarFuncionarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(funcionarioService.buscarFuncionarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarFuncionarioPorEmail(@RequestParam String email) {
        funcionarioService.deletarFuncionarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping // Atualiza todos os campos do banco de dados
    public ResponseEntity<Void> atualizarFuncionarioPorId(@RequestParam Integer id, @RequestBody Funcionario funcionario) {
        funcionarioService.atualizarFuncionarioPorId(id, funcionario);
        return ResponseEntity.ok().build();
    }
}
