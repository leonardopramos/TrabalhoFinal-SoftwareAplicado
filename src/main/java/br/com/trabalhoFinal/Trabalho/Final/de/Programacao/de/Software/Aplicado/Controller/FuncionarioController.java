package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/funcionario")
public class FuncionarioController {
    @PostMapping("/cadastro")
    public ResponseEntity cadastroFuncionario(){

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
