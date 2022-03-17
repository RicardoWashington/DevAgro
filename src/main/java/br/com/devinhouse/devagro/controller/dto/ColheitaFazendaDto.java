package br.com.devinhouse.devagro.controller.dto;

import br.com.devinhouse.devagro.model.Fazenda;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ColheitaFazendaDto {
    private BigDecimal estoque;

    public Fazenda converterEdicao(){
        Fazenda fazenda = new Fazenda();
        fazenda.setEstoque(estoque);
        fazenda.setUltimaColheita(LocalDate.now());
        return fazenda;
    }
}
