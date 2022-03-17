package br.com.devinhouse.devagro.repository;

import br.com.devinhouse.devagro.model.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long> {

    public Grao findByNome(String nome);
    public List<Grao> findAllByEmpresa_Id(Long id);

}
