package br.com.devinhouse.devagro.repository;

import br.com.devinhouse.devagro.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    public Empresa findByNome(String nome);

}
