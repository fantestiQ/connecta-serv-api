package com.app.coneccta.domain.candidato;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;


public record CandidatoDTO(
        @CPF(message = "CPF inválido")
        @NotBlank(message = "O campo CPF é obrigatório!")
        String cpf,

        @Past(message = "A data de nascimento deve estar no passado!")
        @NotNull(message = "O campo data de nascimento é obrigatório!")
        LocalDate dataNascimento,

        String descricao
  ) {
}
