package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Controller;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.Funcionario;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.FuncionarioRepository;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/cadastro")
    public ResponseEntity cadastroFuncionario(@RequestBody String nome, String senha){
        Funcionario funcionario = Funcionario.builder().nome(nome).senha(senha).build();
        funcionarioService.cadastroFuncionario(funcionario);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity loginFuncionario(){

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastro-reembolso")
    public ResponseEntity cadastroReembolso(){

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/cadastro-reembolso")
    public ResponseEntity visualizaReembolsos(){

        return ResponseEntity.ok().build();
    }
}
