package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenteService {

    @Autowired
    GerenteRepository GerenteRepository;

    public void cadastroGerente(Gerente gerente){
        if(gerente.nome != null && gerente.senha !=null){
            GerenteRepository.save(gerente);
        } else throw new RuntimeException();
    }
}
