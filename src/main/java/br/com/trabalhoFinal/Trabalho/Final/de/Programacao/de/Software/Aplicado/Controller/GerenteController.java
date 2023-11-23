package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Controller;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Infra.Exception.ErroDeAutenticacao;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.DatasDTO;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.Gerente;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.GerenteDTO;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.GerenteService;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.ReembolsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    public ResponseEntity loginGerente(@RequestBody Gerente gerente){
        Gerente gerenteEncontrado = gerenteService.loginGerente(gerente);

        if (gerenteEncontrado==null)throw new ErroDeAutenticacao("Gerente nao cadastrado");

        return ResponseEntity.ok().body(gerenteEncontrado);
    }

    @PatchMapping("/reembolso/aprovar/{id}")
    public ResponseEntity aprovaReembolso(@PathVariable Long id){
        reembolsoService.aprovaReembolso(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/reembolso/reprovar/{id}")
    public ResponseEntity reprovaReembolso(@PathVariable Long id){
        reembolsoService.reprovaReembolso(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/reembolso/relatorio")
    public ResponseEntity gerarRelatorio(@RequestBody DatasDTO datas){
        LocalDate inicio = datas.inicio();
        LocalDate fim = datas.fim();

        var relatorio = reembolsoService.relatorio(inicio,fim);

        return ResponseEntity.ok().body(relatorio);
    }
}
