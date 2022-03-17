package br.com.devinhouse.devagro.service;

import br.com.devinhouse.devagro.model.Funcionario;
import br.com.devinhouse.devagro.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> listaFuncionarios(){
        return (List<Funcionario>) repository.findAll();
    }

    public List<Funcionario> listaFuncionarioEmp(Long id){
        return repository.findAllByEmpresa_Id(id);
    }

    public Long contaFuncionariosEmp(Long id){
        return repository.countAllByEmpresa_Id(id);
    }

    public Funcionario adicionaFuncionario (Funcionario funcionario){
        return repository.save(funcionario);
    }

    public Funcionario atualizaFuncionario(Long id, Funcionario funcionario){
        Funcionario funcionarioAtualizado = repository.findById(id).get();
        funcionarioAtualizado.setNome(funcionario.getNome());
        funcionarioAtualizado.setSobrenome(funcionario.getSobrenome());
        funcionarioAtualizado.setCpf(funcionario.getCpf());
        funcionarioAtualizado.setEndereco(funcionario.getEndereco());
        funcionarioAtualizado.setNascimento(funcionario.getNascimento());
        funcionarioAtualizado.setTelefone(funcionario.getTelefone());
        funcionarioAtualizado.setSexo(funcionario.getSexo());
        funcionarioAtualizado.setContratacao(funcionario.getContratacao());
        funcionarioAtualizado.setEmpresa(funcionario.getEmpresa());
        return repository.save(funcionarioAtualizado);
    }

    public void deletaFuncionario(Long id){
        repository.deleteById(id);
    }
}
