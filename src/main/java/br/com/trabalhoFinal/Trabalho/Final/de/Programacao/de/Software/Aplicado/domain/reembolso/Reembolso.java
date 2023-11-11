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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private LocalDate dataReembolso;

    @Enumerated(EnumType.STRING)
    private Motivo motivo;

    @Enumerated(value = EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
}
