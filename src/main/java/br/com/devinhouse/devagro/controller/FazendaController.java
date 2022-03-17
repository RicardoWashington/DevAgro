package br.com.devinhouse.devagro.controller;

import br.com.devinhouse.devagro.controller.dto.ColheitaFazendaDto;
import br.com.devinhouse.devagro.controller.dto.NovaFazendaDto;
import br.com.devinhouse.devagro.model.Empresa;
import br.com.devinhouse.devagro.model.Fazenda;
import br.com.devinhouse.devagro.service.EmpresaService;
import br.com.devinhouse.devagro.service.FazendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fazenda")
public class FazendaController {
    private FazendaService service;
    private EmpresaService empresaService;
    private Empresa empresa;

    public FazendaController(FazendaService service){
        this.service = service;
    }

    @GetMapping
    public String fazenda(){
        return "Fazenda";
    }

    @GetMapping("/todos")
    public List<Fazenda> listarFazendas(){
        return service.listaFazendas();
    }

    //Endpoint 2
    @GetMapping("/empresas/{id}")
    public ResponseEntity<List<Fazenda>> listarFazendasEmp(@PathVariable Long id){
        return ResponseEntity.ok().body(service.listaFazendasEmp(id));
    }
    //Endpoint 3
    @GetMapping("/empresas/contagem/{id}")
    public ResponseEntity<Long> contarFazendasEmp(@PathVariable Long id){
        return ResponseEntity.ok().body(service.contaFazendasEmp(id));
    }
    //Endpoint 4
    @GetMapping("/todascolheitas/{id}")
    public List<String> listarColheitaFazendas(@PathVariable Long id){
        return service.listaColheitaFazendas(id);
    }

    @PostMapping
    public Fazenda adicionarFazenda(@RequestBody NovaFazendaDto fazendaDto){
        return service.adicionaFazenda(fazendaDto.converter());
    }
    //Endpoint 5
    @PutMapping("/colheita/{id}")
    public Fazenda colheitaFazenda(@PathVariable Long id, @RequestBody ColheitaFazendaDto fazendaDto){
        return service.colheitaFazenda(id, fazendaDto.converterEdicao());
    }
    //Endpoint 6
    @PutMapping("/retirada/{id}")
    public Fazenda retiradaFazenda(@PathVariable Long id, @RequestBody ColheitaFazendaDto fazendaDto){
        return service.retiraFazenda(id, fazendaDto.converterEdicao());
    }

    //Endpoint 7
    @GetMapping("/graos/{id}")
    public List<String> listarGraoFazendas(@PathVariable Long id){
        return service.listaFazendasGrao(id);
    }

    //Endpoint 8
    @GetMapping("/empresas/graos/{id}")
    public List<String> listarFazendasEmpGrao(@PathVariable Long id){
        return service.listaFazendasEmpGrao(id);
    }

    @DeleteMapping("/{id}")
    public void deletarFazenda(@PathVariable Long id){
        service.deletaFazenda(id);
    }
}
