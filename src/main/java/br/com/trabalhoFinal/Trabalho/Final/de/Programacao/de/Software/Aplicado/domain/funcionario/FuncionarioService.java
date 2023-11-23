package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Infra.Exception.ErroValidacaoCadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public void valida(Funcionario funcionario){
        if(funcionario.nome == null) throw new ErroValidacaoCadastro("Adicione um nome ao funcionario");

        if(funcionario.senha ==null) throw new ErroValidacaoCadastro("Adicione uma senha para funcionario");
    }

    public void cadastroFuncionario(Funcionario funcionario){
        valida(funcionario);

        funcionarioRepository.save(funcionario);
    }

    public void funcionarioExistePeloId(Long id){
        if(!funcionarioRepository.existsById(id)) throw new RuntimeException();
    }

    public Funcionario validaFuncionario(Funcionario funcionario){
        valida(funcionario);

        List<Funcionario> list = findAll();
        for(Funcionario func : list){
            if(func.getNome().equals(funcionario.getNome()) && func.getSenha().equals(funcionario.getSenha())){
                return func;
            }
        }

        return null;
    }

    public Funcionario findByid(Long id) {
        funcionarioExistePeloId(id);
        Funcionario funcionario = funcionarioRepository.findById(id).get();
        return funcionario;
    }
    public boolean loginById(Long id) {
        funcionarioExistePeloId(id);
        return true;
    }
    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }
}
