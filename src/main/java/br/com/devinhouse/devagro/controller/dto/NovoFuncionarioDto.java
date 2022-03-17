package br.com.devinhouse.devagro.controller.dto;

import br.com.devinhouse.devagro.model.Empresa;
import br.com.devinhouse.devagro.model.Funcionario;
import br.com.devinhouse.devagro.model.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class NovoFuncionarioDto {
    @NotBlank(message = "Nome não deve estar em branco.")
    private String nome;
    @NotBlank(message = "Sobrenome não deve estar em branco.")
    private String sobrenome;
    @NotBlank @CPF(message = "CPF Inválido.")
    private String cpf;
    @NotBlank(message = "Endereço não pode estar em branco.")
    private String endereco;
    @Pattern(regexp = "(\\d{2}) \\d{5}-\\d{4}")
    private String telefone;
    private Sexo sexo;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate nascimento;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate contratacao;
    @NotBlank(message = "Empresa deve ser informada.")
    private Empresa empresa;

    public Funcionario converter(){
        Funcionario funcio = new Funcionario();
        funcio.setNome(nome);
        funcio.setSobrenome(sobrenome);
        funcio.setCpf(cpf);
        funcio.setEndereco(endereco);
        funcio.setTelefone(telefone);
        funcio.setSexo(sexo);
        funcio.setNascimento(nascimento);
        funcio.setContratacao(contratacao);
        funcio.setEmpresa(empresa);
        return funcio;
    }
}
