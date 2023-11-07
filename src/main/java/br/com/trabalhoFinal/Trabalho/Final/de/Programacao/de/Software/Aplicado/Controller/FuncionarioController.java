package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Controller;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.Funcionario;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.FuncionarioService;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.Estado;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.Motivo;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.Reembolso;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.ReembolsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    ReembolsoService reembolsoService;

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

    @PostMapping("/reembolso")
    public ResponseEntity cadastroReembolso(@RequestBody Double valor, Motivo motivo, Estado estado, LocalDate dataReembolso){
        Reembolso reembolso = Reembolso.builder()
                .valor(valor)
                .motivo(motivo)
                .estado(estado)
                .dataReembolso(dataReembolso)
                .build();

        reembolsoService.cadastraReembolso(reembolso);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/reembolso")
    public ResponseEntity visualizaReembolsos(){
        
        return ResponseEntity.ok().build();
    }
}
