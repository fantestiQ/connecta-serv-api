package com.app.coneccta.domain.user;

import com.app.coneccta.domain.enderecos.Endereco;
import com.app.coneccta.domain.enderecos.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserDTO(

        @Size(min = 5, max = 128, message = "O nome fantasia deve ter conter no mínimo 3 caracteres!")
        @NotBlank(message = "O campo nome é obrigatório!")
        String name,

        @Email(message = "Formato de email inválido")
        @NotBlank(message = "O campo email é obrigatório!")
        String email,

        @NotBlank(message = "O campo password é obrigatório!")
        String password,

        @NotBlank(message = "O campo telefone é obrigatório!")
        @Size(min = 11 , max = 15)
        String telefone,


        @Valid
        @NotNull(message = "A informação de endereço é necessária!")
        List<Endereco> Enderecos
        ){
}
