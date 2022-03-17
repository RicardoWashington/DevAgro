package br.com.devinhouse.devagro.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "endereco")
    private String endereco;
//    @OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST)
//    private List<Fazenda> fazendas;
//    @OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST)
//    private List<Grao> graos;
//    @OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST)
//    private List<Funcionario> funcionarios;
}
