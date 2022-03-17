package br.com.devinhouse.devagro.controller.dto;

import br.com.devinhouse.devagro.model.Empresa;
import br.com.devinhouse.devagro.model.Grao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class NovoGraoDto {
    @NotBlank
    private String nome;
    @NotBlank
    private int tempoMedio;
    @NotBlank
    private Empresa empresa;

    public Grao converter(){
        Grao grao = new Grao();
        grao.setNome(nome);
        grao.setEmpresa(empresa);
        grao.setTempoMedio(tempoMedio);
        return grao;
    }
}
