package br.com.devinhouse.devagro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "fazenda")
public class Fazenda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "estoque")
    private BigDecimal estoque;
    @Column(name = "ultima_colheita")
    private LocalDate ultimaColheita;
    @Column(name = "proxima_colheita")
    private LocalDate proximaColheita;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "grao_id")
    private Grao grao;
}
