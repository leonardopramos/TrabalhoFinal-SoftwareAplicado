package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public void cadastroFuncionario(Funcionario funcionario){
        if(funcionario.nome != null && funcionario.senha !=null){
            funcionarioRepository.save(funcionario);
        } else throw new RuntimeException();
    }
}
