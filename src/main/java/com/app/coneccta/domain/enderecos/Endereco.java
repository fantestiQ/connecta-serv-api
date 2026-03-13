package com.app.coneccta.domain.enderecos;

import com.app.coneccta.domain.listeners.DatesBase;
import com.app.coneccta.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Endereco")
@Table(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Endereco extends DatesBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String uf;

    private boolean principal = true;

    public static Endereco  createEndereco(EnderecoDTO enderecoDTO, User user) {
        Endereco endereco= new Endereco();

        endereco.setUser(user);
        endereco.setCep(enderecoDTO.cep());
        endereco.setLogradouro(enderecoDTO.logradouro());
        endereco.setCidade(enderecoDTO.cidade());
        endereco.setBairro(enderecoDTO.bairro());
        endereco.setNumero(enderecoDTO.numero());
        endereco.setUf(enderecoDTO.uf());

        return endereco;
    }
}
