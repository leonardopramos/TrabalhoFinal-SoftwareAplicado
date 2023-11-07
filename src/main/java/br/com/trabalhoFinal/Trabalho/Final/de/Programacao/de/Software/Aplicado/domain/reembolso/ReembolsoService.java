package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReembolsoService {

    @Autowired
    ReembolsoRepository reembolsoRepository;

    public boolean valida(Reembolso reembolso){
        if(reembolso.valor < 0)throw new RuntimeException();;

        if(reembolso.estado == null) throw new RuntimeException();

        if(reembolso.motivo == null) throw new RuntimeException();

        if(reembolso.dataReembolso == null)throw new RuntimeException();

        return true;
    }

    public void cadastraReembolso(Reembolso reembolso){
        if(valida(reembolso)) reembolsoRepository.save(reembolso);
        else throw new RuntimeException();
    }
}
