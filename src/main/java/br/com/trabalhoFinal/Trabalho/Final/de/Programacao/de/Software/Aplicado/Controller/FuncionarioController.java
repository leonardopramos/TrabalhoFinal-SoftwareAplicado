package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Controller;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.Funcionario;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.FuncionarioDTO;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.FuncionarioService;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.Estado;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.Reembolso;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.ReembolsoDTO;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso.ReembolsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    ReembolsoService reembolsoService;

    @PostMapping("/cadastro")
    public ResponseEntity cadastroFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = Funcionario.builder().nome(funcionarioDTO.nome()).senha(funcionarioDTO.senha()).build();
        funcionarioService.cadastroFuncionario(funcionario);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity loginFuncionario(){

        return ResponseEntity.ok().build();
    }

    @PostMapping("/reembolso")
    public ResponseEntity cadastroReembolso(@RequestBody ReembolsoDTO reembolsoDTO){
        Reembolso reembolso = Reembolso.builder()
                .valor(reembolsoDTO.valor())
                .motivo(reembolsoDTO.motivo())
                .estado(Estado.PENDENTE)
                .dataReembolso(reembolsoDTO.dataReembolso())
                .funcionario(null) //FAZER AQUI!!!!!
                .build();

        reembolsoService.cadastraReembolso(reembolso);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/reembolso")
    public ResponseEntity visualizaReembolsos(){
        var reembolsos = reembolsoService.listaTodosProcessosFuncionario();

        return ResponseEntity.ok().body(reembolsos);
    }
}
