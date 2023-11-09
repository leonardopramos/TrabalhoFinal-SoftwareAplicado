package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.Funcionario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Reembolso")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Reembolso {
    private Double valor;
    private Motivo motivo;
    private Estado estado;
    private LocalDate dataReembolso;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
