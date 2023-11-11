package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.Funcionario;

import java.time.LocalDate;

public record FiltroRelatorioDTO(Double valor, LocalDate dataReembolso, Motivo motivo, Estado estado, Funcionario funcionario) {
}
