package com.app.coneccta.domain.enderecos;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(
         @NotBlank(message = "O campo cep é obrigatório!")
         String cep,

         @NotBlank(message = "O campo logradouro é obrigatório!")
         String logradouro,

         @NotBlank(message = "O campo cidade é obrigatório!")
         String cidade,

         @NotBlank(message = "O campo bairro é obrigatório!")
         String bairro,

         @NotBlank(message = "O campo número é obrigatório!")
         String numero,

         @NotBlank(message = "O campo uf é obrigatório!")
         String uf,
         boolean principal
) {
}
