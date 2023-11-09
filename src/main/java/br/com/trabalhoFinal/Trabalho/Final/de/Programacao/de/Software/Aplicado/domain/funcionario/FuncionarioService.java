package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public void valida(Funcionario funcionario){
        if(funcionario.nome == null) throw new RuntimeException();

        if(funcionario.senha ==null) throw new RuntimeException();
    }

    public void cadastroFuncionario(Funcionario funcionario){
        valida(funcionario);

        funcionarioRepository.save(funcionario);
    }

    public void funcionarioExiste(Long id){
        if(!funcionarioRepository.existsById(id)) throw new RuntimeException();
    }

    public Funcionario findByid(Long id) {
        funcionarioExiste(id);
        Funcionario funcionario = funcionarioRepository.findById(id).get();
        return funcionario;
    }
}
