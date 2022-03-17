package br.com.devinhouse.devagro.controller;

import br.com.devinhouse.devagro.controller.dto.NovaEmpresaDto;
import br.com.devinhouse.devagro.model.Empresa;
import br.com.devinhouse.devagro.service.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    private EmpresaService service;

    public EmpresaController(EmpresaService service){
        this.service = service;
    }

    @GetMapping(produces="application/json")
    public String empresa(){
        return "Empresa";
    }

    //Endpoint 1
    @GetMapping("/todos")
    public List<Empresa> listarEmpresas(){
        return service.listaEmpresas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Long id) {
        Empresa empresa = service.listaEmpresaId(id);
        return ResponseEntity.ok().body(empresa);
    }

    @PostMapping(produces="application/json", consumes = "Application/json")
    public Empresa adicionarEmpresa(@Valid @RequestBody NovaEmpresaDto empresaDto){
        return service.adicionaEmpresa(empresaDto.converter());
    }

    @PutMapping("/{id}")
    public Empresa atualizarEmpresa(@PathVariable Long id, @RequestBody NovaEmpresaDto empresaDto){
        return service.atualizaEmpresa(id, empresaDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletarEmpresa(@PathVariable Long id){
        service.deletaEmpresa(id);
    }

}
