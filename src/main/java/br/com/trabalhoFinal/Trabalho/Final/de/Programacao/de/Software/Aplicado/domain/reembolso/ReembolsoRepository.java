package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.reembolso;

import br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReembolsoRepository extends JpaRepository<Reembolso,Long> {
    List<Reembolso> findAllByFuncionario(Funcionario funcionario);
}
