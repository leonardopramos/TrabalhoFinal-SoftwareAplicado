package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "Funcionario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Funcionario {
    String nome;
    String senha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
