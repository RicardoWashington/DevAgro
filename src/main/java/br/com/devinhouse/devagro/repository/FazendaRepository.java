package br.com.devinhouse.devagro.repository;

import br.com.devinhouse.devagro.model.Fazenda;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FazendaRepository extends JpaRepository<Fazenda, Long> {

    public Fazenda findByNome(String nome);
    public List<Fazenda> findAllByEmpresa_Id(Long id);
    public Long countAllByEmpresa_Id(Long id);



}
