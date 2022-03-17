package br.com.devinhouse.devagro.controller.dto;

import br.com.devinhouse.devagro.model.Fazenda;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RetiradaFazendaDto {
    private BigDecimal estoque;

    public Fazenda converterEdicao(){
        Fazenda fazenda = new Fazenda();
        fazenda.setEstoque(estoque);
        return fazenda;
    }
}
