package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso;

public record DadosRelatorioDTO(Integer quantidadeAprovados,String porcentagemAprovados, Double totalAprovados,
                             Integer quantidadeReprovados,String porcentagemReprovados, Double totalReprovados) {
}
