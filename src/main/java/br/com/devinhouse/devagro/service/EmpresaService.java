package br.com.devinhouse.devagro.service;

import br.com.devinhouse.devagro.model.Empresa;
import br.com.devinhouse.devagro.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }
    public List<Empresa> listaEmpresas(){
        return (List<Empresa>) repository.findAll();
    }

    public Empresa listaEmpresaId(Long id) {
        Optional<Empresa> empresa = repository.findById(id);
        return empresa.get();
    }

    public Empresa adicionaEmpresa(Empresa empresa){
        return repository.save(empresa);
    }
    public Empresa atualizaEmpresa(Long id, Empresa empresa){
        Empresa empresaAtualizada = repository.findById(id).get();
        empresaAtualizada.setNome(empresa.getNome());
        empresaAtualizada.setCnpj(empresa.getCnpj());
        empresaAtualizada.setEndereco(empresa.getEndereco());
        return repository.save(empresaAtualizada);
    }
    public void deletaEmpresa(Long id){
        repository.deleteById(id);
    }
}
