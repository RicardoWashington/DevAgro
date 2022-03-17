package br.com.devinhouse.devagro.repository;

import br.com.devinhouse.devagro.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public Funcionario findByNome(String nome);
    public List<Funcionario> findAllByEmpresa_Id(Long id);
    public Long countAllByEmpresa_Id(Long id);
}
