package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Controller;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.Gerente;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

    @Autowired
    GerenteService gerenteService;

    @PostMapping("/cadastro")
    public ResponseEntity cadastroGerente(@RequestBody String nome, String senha){
        Gerente gerente = Gerente.builder().nome(nome).senha(senha).build();
        gerenteService.cadastroGerente(gerente);

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
