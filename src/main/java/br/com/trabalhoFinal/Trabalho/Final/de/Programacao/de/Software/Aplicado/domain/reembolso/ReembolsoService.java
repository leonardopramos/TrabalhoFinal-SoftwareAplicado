package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class ReembolsoService {

    @Autowired
    ReembolsoRepository reembolsoRepository;

    public void valida(Reembolso reembolso){
        if(reembolso.getValor()< 0)throw new RuntimeException();;

        if(reembolso.getMotivo() == null) throw new RuntimeException();

        if(reembolso.getDataReembolso() == null)throw new RuntimeException();
    }

    public void cadastraReembolso(Reembolso reembolso){
        valida(reembolso);

        reembolsoRepository.save(reembolso);
    }

    public ArrayList<Reembolso> listaTodosProcessosFuncionario(){
        ArrayList<Reembolso> listaReembolsos = new ArrayList<>();

        var todosReembolsos = reembolsoRepository.findAll();

        for (Reembolso reembolso: todosReembolsos){
            if(Objects.equals(reembolso.getFuncionario().getId(), reembolso.getId())){
                listaReembolsos.add(reembolso);
            }
        }

        return listaReembolsos;
    }
}
