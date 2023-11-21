package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Controller;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.Funcionario;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.DatasDTO;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.Gerente;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.GerenteDTO;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente.GerenteService;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.Reembolso;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.ReembolsoRepository;
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
    public ResponseEntity loginGerente(@RequestBody Gerente g){
        List<Gerente> list = gerenteService.findAll();
        for(Gerente gen : list){
            if(gen.getNome().equals(g.getNome()) && gen.getSenha().equals(g.getSenha())){
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
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
