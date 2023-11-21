package br.com.trabalhoFinal.Trabalho.Final.de.Programacao.de.Software.Aplicado.domain.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    @Override
    boolean existsById(Long aLong);

    @Override
    List<Funcionario> findAll();
}
