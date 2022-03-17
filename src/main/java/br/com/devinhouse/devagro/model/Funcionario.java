package br.com.devinhouse.devagro.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table()
public class Funcionario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @CPF
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "sexo")
    private Sexo sexo;
    @Column(name = "nascimento")
    private LocalDate nascimento;
    @Column(name = "contratacao")
    private LocalDate contratacao;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}
