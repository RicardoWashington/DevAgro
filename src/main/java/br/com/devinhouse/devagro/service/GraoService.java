package br.com.devinhouse.devagro.service;

import br.com.devinhouse.devagro.model.Grao;
import br.com.devinhouse.devagro.repository.GraoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraoService {
    private final GraoRepository repository;

    public GraoService(GraoRepository repository) {
        this.repository = repository;
    }

    public List<Grao> listaGraos(){
        return (List<Grao>) repository.findAll();
    }

    public List<Grao> listaGraosEmp(Long id){
        return repository.findAllByEmpresa_Id(id);
    }

    public Grao adicionaGrao(Grao grao){
        return repository.save(grao);
    }

    public Grao atualizaGrao(Long id, Grao grao){
        Grao graoAtualizado = repository.findById(id).get();
        graoAtualizado.setNome(grao.getNome());
        graoAtualizado.setEmpresa(grao.getEmpresa());
        graoAtualizado.setTempoMedio(grao.getTempoMedio());
        return repository.save(graoAtualizado);
    }

    public void deletaGrao(long id){
        repository.deleteById(id);
    }
}
