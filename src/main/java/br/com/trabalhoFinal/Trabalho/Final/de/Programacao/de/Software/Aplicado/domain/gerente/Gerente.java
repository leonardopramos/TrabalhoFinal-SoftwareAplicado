package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.gerente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "Gerente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Gerente {
    private String nome;
    private String senha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
