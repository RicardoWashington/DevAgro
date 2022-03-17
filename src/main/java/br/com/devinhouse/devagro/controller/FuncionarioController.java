package br.com.devinhouse.devagro.controller;

import br.com.devinhouse.devagro.controller.dto.NovoFuncionarioDto;
import br.com.devinhouse.devagro.model.Fazenda;
import br.com.devinhouse.devagro.model.Funcionario;
import br.com.devinhouse.devagro.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private FuncionarioService service;

    public FuncionarioController(FuncionarioService service){
        this.service = service;
    }

    @GetMapping
    public String funcionario(){
        return "Funcionario";
    }

    @GetMapping("/todos")
    public List<Funcionario> listarFuncionarios(){
        return service.listaFuncionarios();
    }

    //Endpoint 9
    @GetMapping("/empresas/{id}")
    public ResponseEntity<List<Funcionario>> listarFuncionariosEmp(@PathVariable Long id){
        return ResponseEntity.ok().body(service.listaFuncionarioEmp(id));
    }
    //Endpoint 10
    @GetMapping("/empresas/contagem/{id}")
    public ResponseEntity<Long> contarFuncionariosEmp(@PathVariable Long id){
        return ResponseEntity.ok().body(service.contaFuncionariosEmp(id));
    }

    @PostMapping
    public Funcionario adicionarFuncionario(@RequestBody NovoFuncionarioDto funcionarioDto){
        return service.adicionaFuncionario(funcionarioDto.converter());
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody NovoFuncionarioDto funcionarioDto){
        return service.atualizaFuncionario(id, funcionarioDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Long id){
        service.deletaFuncionario(id);
    }
}
