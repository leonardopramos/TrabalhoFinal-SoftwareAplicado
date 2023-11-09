package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Controller;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.Gerente;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.GerenteDTO;
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
    public ResponseEntity cadastroGerente(@RequestBody GerenteDTO gerenteDTO){
        Gerente gerente = Gerente.builder().nome(gerenteDTO.nome()).senha(gerenteDTO.senha()).build();
        gerenteService.cadastroGerente(gerente);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity loginGerente(){

        return ResponseEntity.ok().build();
    }

    @PutMapping("/validar-reembolso/{$id}")
    public ResponseEntity validaReembolso(@PathVariable Long id){


        return ResponseEntity.ok().build();
    }

    @GetMapping("/gerar-relatorio")
    public ResponseEntity gerarRelatorio(){

        return ResponseEntity.ok().build();
    }
}
