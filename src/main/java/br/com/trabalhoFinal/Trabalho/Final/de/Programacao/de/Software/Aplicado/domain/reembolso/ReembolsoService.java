package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Infra.Exception.ErroReembolsoInexistente;
import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.Infra.Exception.ErroValidacaoCadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReembolsoService {

    @Autowired
    ReembolsoRepository reembolsoRepository;

    public void valida(Reembolso reembolso){
        if(reembolso.getValor()< 0)throw new ErroValidacaoCadastro("Adicione um valor ao reembolso");

        if(reembolso.getMotivo() == null) throw new ErroValidacaoCadastro("Adicione um motivo ao reembolso");

        if(reembolso.getDataReembolso() == null)throw new ErroValidacaoCadastro("Adicione uma data ao reembolso");
    }

    public void cadastraReembolso(Reembolso reembolso){
        valida(reembolso);
        reembolsoRepository.save(reembolso);
    }

    public List<Reembolso> listaTodosReembolsos(){
        return reembolsoRepository.findAll();
    }

    public List<Reembolso> listaTodosReembolsosFuncionario(Long id){
        List<Reembolso> listaReembolsos = new ArrayList<>();

        var reembolsos = reembolsoRepository.findAll();

        for (Reembolso reembolso: reembolsos){
            if(Objects.equals(reembolso.getFuncionario().getId(), id)){
                listaReembolsos.add(reembolso);
            }
        }

        return listaReembolsos;
    }

    public void aprovaReembolso(Long id){
        Optional<Reembolso> reembolsoEncontrado = reembolsoRepository.findById(id);

        if (reembolsoEncontrado.isPresent()) {
            Reembolso reembolso = reembolsoEncontrado.get();
            reembolso.setEstado(Estado.APROVADO);
            reembolsoRepository.save(reembolso);
        } throw new ErroReembolsoInexistente("Adicione um valor ao reembolso");
    }

    public void reprovaReembolso(Long id){
        Optional<Reembolso> reembolsoEncontrado = reembolsoRepository.findById(id);

        if (reembolsoEncontrado.isPresent()) {
            Reembolso reembolso = reembolsoEncontrado.get();
            reembolso.setEstado(Estado.REPROVADO);
            reembolsoRepository.save(reembolso);
        } throw new ErroReembolsoInexistente("Adicione um valor ao reembolso");
    }

    public DadosRelatorioDTO relatorio(LocalDate inicio, LocalDate fim){
        if(inicio == null) throw new RuntimeException("data de inicio nao informada");
        if(fim == null) throw new RuntimeException("data de fim nao informada");

        List<Reembolso> reembolsos = reembolsoRepository.findAll();

        List<Double> valoresAprovados = new ArrayList<>();

        List<Double> valoresReprovados = new ArrayList<>();

        for(Reembolso reembolso:reembolsos){
            LocalDate dataReembolso = reembolso.getDataReembolso();

            if (dataReembolso.isEqual(inicio) || dataReembolso.isEqual(fim) || (dataReembolso.isAfter(inicio) && dataReembolso.isBefore(fim))){
                if(reembolso.getEstado().equals(Estado.APROVADO)){
                    valoresAprovados.add(reembolso.getValor());
                }else if (reembolso.getEstado().equals(Estado.REPROVADO)){
                    valoresReprovados.add(reembolso.getValor());
                }
            }
        }

        int quantidadeTotal = valoresAprovados.size()+valoresReprovados.size();

        DadosRelatorio resultadoAprovados = calculosRelatorio(quantidadeTotal,valoresAprovados);
        DadosRelatorio resultadoReprovados = calculosRelatorio(quantidadeTotal,valoresReprovados);

        return new DadosRelatorioDTO(resultadoAprovados.quantidade(),resultadoAprovados.porcentagem(),resultadoAprovados.total(),
                resultadoReprovados.quantidade(),resultadoReprovados.porcentagem(),resultadoReprovados.total());
    }

    public DadosRelatorio calculosRelatorio(int quantidadeTotal,List<Double> valores){
        int quantidade = valores.size();

        Double porcentagem =(((double) quantidade / quantidadeTotal) * 100);
        String porcentagemString = porcentagem+"%";

        Double valorTotal = valores.stream().mapToDouble(Double::doubleValue).sum();

        return new DadosRelatorio(quantidade,porcentagemString,valorTotal);
    }
}
