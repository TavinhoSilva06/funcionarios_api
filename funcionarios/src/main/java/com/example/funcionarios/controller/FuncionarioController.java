package com.example.funcionarios.controller;

import com.example.funcionarios.business.FuncionarioService;
import com.example.funcionarios.infrastructure.entitiys.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Funcionario>> listarTodos() {
        return ResponseEntity.ok(funcionarioService.listarTodos());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionarioPorId(@PathVariable Integer id) {
        funcionarioService.deletarFuncionarioPorId(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping // Atualiza todos os campos do banco de dados
    public ResponseEntity<Void> atualizarFuncionarioPorId(@RequestParam Integer id, @RequestBody Funcionario funcionario) {
        funcionarioService.atualizarFuncionarioPorId(id, funcionario);
        return ResponseEntity.ok().build();
    }
}