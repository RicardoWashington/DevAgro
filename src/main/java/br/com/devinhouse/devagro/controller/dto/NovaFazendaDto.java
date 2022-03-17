package br.com.devinhouse.devagro.controller.dto;

import br.com.devinhouse.devagro.model.Empresa;
import br.com.devinhouse.devagro.model.Fazenda;
import br.com.devinhouse.devagro.model.Grao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class NovaFazendaDto {
    @NotBlank(message = "Nome não deve estar em branco.")
    private String nome;
    @NotBlank(message = "Endereço não pode estar em branco.")
    private String endereco;
    @Negative(message = "Não é permitido estoque negativo.")
    private BigDecimal estoque;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate ultimaColheita;
    @NotBlank(message = "Empresa deve ser informada.")
    private Empresa empresa;
    @NotBlank(message = "Grão deve ser informado.")
    private Grao grao;

    public Fazenda converter(){
        Fazenda fazenda = new Fazenda();
        fazenda.setNome(nome);
        fazenda.setEndereco(endereco);
        fazenda.setEstoque(estoque);
        fazenda.setUltimaColheita(ultimaColheita);
        fazenda.setEmpresa(empresa);
        fazenda.setGrao(grao);
        return fazenda;
    }
}
