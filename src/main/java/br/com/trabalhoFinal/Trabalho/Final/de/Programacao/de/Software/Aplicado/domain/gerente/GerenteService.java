package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {

    @Autowired
    GerenteRepository GerenteRepository;

    public void cadastroGerente(Gerente gerente){
        if(gerente.getNome() != null || gerente.getSenha() !=null){
            GerenteRepository.save(gerente);
        } else throw new RuntimeException();
    }

    public List<Gerente> findAll() {
        return GerenteRepository.findAll();
    }
}
