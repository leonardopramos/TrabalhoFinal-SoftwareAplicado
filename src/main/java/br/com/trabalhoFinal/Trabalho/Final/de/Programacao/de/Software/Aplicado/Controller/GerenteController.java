package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/gerente")
public class GerenteController {

    @PostMapping("/cadastro")
    public ResponseEntity cadastroGerente(){

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity loginGerente(){

        return ResponseEntity.ok().build();
    }

    @PutMapping("/validar-reembolso")
    public ResponseEntity validaReembolso(){

        return ResponseEntity.ok().build();
    }

    @GetMapping("/validar-reembolso")
    public ResponseEntity gerarRelatorio(){

        return ResponseEntity.ok().build();
    }
}
