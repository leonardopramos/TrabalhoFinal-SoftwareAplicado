package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Controller;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Infra.Exception.ErroDeAutenticacao;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.DatasDTO;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.Gerente;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.GerenteDTO;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.GerenteService;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.Reembolso;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.ReembolsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

    @Autowired
    GerenteService gerenteService;
    @Autowired
    ReembolsoService reembolsoService;

    @PostMapping("/cadastro")
    public ResponseEntity cadastroGerente(@RequestBody GerenteDTO gerenteDTO){
        Gerente gerente = Gerente.builder().nome(gerenteDTO.nome()).senha(gerenteDTO.senha()).build();

        gerenteService.cadastroGerente(gerente);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity loginGerente(@RequestParam String nome, String senha){
        Gerente gerenteEncontrado = gerenteService.loginGerente(Gerente.builder().nome(nome).senha(senha).build());

        if (gerenteEncontrado==null)throw new ErroDeAutenticacao("Gerente nao cadastrado");

        return ResponseEntity.ok().body(gerenteEncontrado);
    }

    @GetMapping("/reembolso")
    public ResponseEntity listaTodosReembolsos(){
        List<Reembolso> lista = reembolsoService.listaTodosReembolsos();

        return ResponseEntity.ok().body(lista);
    }

    @PutMapping ("/reembolso/aprovar/{id}")
    public ResponseEntity aprovaReembolso(@PathVariable Long id){
        System.out.println(id);
        reembolsoService.aprovaReembolso(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/reembolso/reprovar/{id}")
    public ResponseEntity reprovaReembolso(@PathVariable Long id){
        reembolsoService.reprovaReembolso(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/reembolso/relatorio")
    public ResponseEntity gerarRelatorio(@RequestParam LocalDate inicio,LocalDate fim){
        var relatorio = reembolsoService.relatorio(inicio,fim);

        return ResponseEntity.ok().body(relatorio);
    }
}
