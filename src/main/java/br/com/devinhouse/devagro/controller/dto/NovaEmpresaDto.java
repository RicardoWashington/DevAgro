package br.com.devinhouse.devagro.controller.dto;
import br.com.devinhouse.devagro.model.Empresa;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class NovaEmpresaDto {
    @NotBlank(message = "Nome não deve estar em branco.")
    private String nome;
    @NotBlank @CNPJ(message = "CNPJ Inválido.")
    private String cnpj;
    @NotBlank(message = "Endereço não pode estar em branco.")
    private String endereco;

    public Empresa converter(){
        Empresa empresa = new Empresa();
        empresa.setNome(nome);
        empresa.setCnpj(cnpj);
        empresa.setEndereco(endereco);
        return empresa;
    }
}
