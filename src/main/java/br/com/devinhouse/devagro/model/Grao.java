package br.com.devinhouse.devagro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "grao")
public class Grao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "tempo_medio")
    private int tempoMedio;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
