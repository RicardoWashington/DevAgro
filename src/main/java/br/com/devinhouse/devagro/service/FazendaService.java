package br.com.devinhouse.devagro.service;

import br.com.devinhouse.devagro.model.Fazenda;
import br.com.devinhouse.devagro.model.Grao;
import br.com.devinhouse.devagro.repository.FazendaRepository;
import br.com.devinhouse.devagro.repository.GraoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class FazendaService {
    public final FazendaRepository repository;
    public GraoRepository graoRepository;

    public FazendaService(FazendaRepository repository) {
        this.repository = repository;
    }

    public List<Fazenda> listaFazendas(){
        return repository.findAll();
    }

    public List<String> listaFazendasGrao(Long id){
        List<Fazenda> fazenda = repository.findAllByEmpresa_Id(id);
        List<String> retornaFazenda = new ArrayList<>();
        for (int i=0;fazenda.size()>i;i++) {
            retornaFazenda.add("Grão:" + fazenda.get(i).getGrao().getNome());
        }
        return retornaFazenda;
    }

    public List<String> listaColheitaFazendas(Long id){
        List<Fazenda> fazenda = repository.findAllByEmpresa_Id(id);
        List<String> retornaFazenda = new ArrayList<>();
        for (int i=0;fazenda.size()>i;i++) {
            retornaFazenda.add("Id:" + String.valueOf(fazenda.get(i).getId()));
            retornaFazenda.add("Fazenda:" + fazenda.get(i).getNome());
            retornaFazenda.add("Próxima Colheita: " + String.valueOf(fazenda.get(i).getProximaColheita()));
        }
        return retornaFazenda;
    }

    public List<Fazenda> listaFazendasEmp(Long id){
        return repository.findAllByEmpresa_Id(id);
    }

    public List<String> listaFazendasEmpGrao(Long id){
        List<Fazenda> fazenda = repository.findAllByEmpresa_Id(id);
        Comparator<Fazenda> comparator = Comparator.comparing(Fazenda::getEstoque);
        Collections.sort(fazenda, comparator);
        List<String> retornaFazenda = new ArrayList<>();
        for( int i=0;fazenda.size()>i;i++){
            retornaFazenda.add("Grão: " + fazenda.get(i).getGrao().getNome());
            retornaFazenda.add("Estoque: " + fazenda.get(i).getEstoque());
        }
        return retornaFazenda;
    }

    public Long contaFazendasEmp(Long id){
        return repository.countAllByEmpresa_Id(id);
    }

    public Fazenda adicionaFazenda(Fazenda fazenda){
        return repository.save(fazenda);
    }

    public Fazenda colheitaFazenda(Long id, Fazenda fazenda){
        Fazenda fazendaAtualizado = repository.findById(id).get();
        Grao grao = fazendaAtualizado.getGrao();
        fazendaAtualizado.setEstoque(fazenda.getEstoque().add(fazendaAtualizado.getEstoque()));
        fazendaAtualizado.setUltimaColheita(fazenda.getUltimaColheita());
        fazendaAtualizado.setProximaColheita(fazenda.getUltimaColheita().plusDays(grao.getTempoMedio()));
        return repository.save(fazendaAtualizado);
    }

    public Fazenda retiraFazenda(Long id, Fazenda fazenda){
        Fazenda fazendaAtualizado = repository.findById(id).get();
        fazendaAtualizado.setEstoque((fazenda.getEstoque().negate()).add(fazendaAtualizado.getEstoque()));
        return repository.save(fazendaAtualizado);
    }


    public void deletaFazenda(Long id){
        repository.deleteById(id);
    }
}
