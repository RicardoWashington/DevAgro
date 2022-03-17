package br.com.devinhouse.devagro.controller;

import br.com.devinhouse.devagro.controller.dto.NovoGraoDto;
import br.com.devinhouse.devagro.model.Grao;
import br.com.devinhouse.devagro.service.GraoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/grao")
public class GraoController {
    private GraoService service;

    public GraoController(GraoService service){
        this.service = service;
    }

    @GetMapping
    public String grao(){
        return "Grao";
    }

    @GetMapping("/todos")
    public List<Grao> listarGraos(){
        return service.listaGraos();
    }

    //Endpoint 7
    @GetMapping("/empresas/{id}")
    public ResponseEntity<List<Grao>> listarGraosEmp(@PathVariable Long id){
        return ResponseEntity.ok().body(service.listaGraosEmp(id));
    }

    @PostMapping
    public Grao adicionarGrao(@RequestBody NovoGraoDto graoDto){
        return service.adicionaGrao(graoDto.converter());
    }

    @PutMapping("/{id}")
    public Grao atualizarGrao(@PathVariable Long id, @RequestBody NovoGraoDto graoDto){
        return service.atualizaGrao(id, graoDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletarGrao(@PathVariable Long id){
        service.deletaGrao(id);
    }
}
