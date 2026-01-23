package com.app.coneccta.domain.empresa;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;


public record EmpresaDTO(
        @Size(min = 5, max = 128, message = "O nome fantasia deve ter conter no mínimo 3 caracteres!")
        @NotBlank(message = "O campo nome fantasia é obrigatório")
        String nome_fantasia,

        @CNPJ
        @NotBlank(message = "O campo nome CNPJ é obrigatório!")
        String cnpj,

        @Size(min = 9, max = 14)
        String inscricaoEstadual,

        String descricao
) {
}
