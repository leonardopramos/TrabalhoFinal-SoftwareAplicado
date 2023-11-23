package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Infra.Exception.ErroValidacaoCadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {

    @Autowired
    GerenteRepository GerenteRepository;

    public void valida(Gerente gerente){
        if(gerente.getNome() == null) throw new ErroValidacaoCadastro("Adicione um nome ao gerente");

        if(gerente.getSenha() ==null) throw new ErroValidacaoCadastro("Adicione uma senha para gerente");
    }

    public void cadastroGerente(Gerente gerente){
        valida(gerente);
        GerenteRepository.save(gerente);
    }

    public List<Gerente> findAll() {
        return GerenteRepository.findAll();
    }

    public Gerente loginGerente(Gerente gerente){
        valida(gerente);

        List<Gerente> list = findAll();
        for(Gerente gen : list){
            if(gen.getNome().equals(gerente.getNome()) && gen.getSenha().equals(gerente.getSenha())){
                return gen;
            }
        }

        return null;
    }
}
