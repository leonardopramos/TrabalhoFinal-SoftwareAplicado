package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.Funcionario;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Reembolso")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Reembolso {
    Double valor;
    Motivo motivo;
    Estado estado;
    LocalDate dataReembolso;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    Funcionario funcionario;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
