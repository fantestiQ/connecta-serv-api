package com.app.coneccta.domain.empresa;

import com.app.coneccta.domain.candidato.Candidato;
import com.app.coneccta.domain.listeners.DatesBase;
import com.app.coneccta.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;


import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Entity(name = "Empresa")
@Table(name = "empresas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Empresa extends DatesBase {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, updatable = false, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(unique = true, nullable = false)
    private String cnpj;

    @Column(name ="inscricao_estadual" , unique = true)
    private String inscricaoEstadual;

    private String descricao;

    public static Empresa createEmpresa(EmpresaDTO empresaDTO, User user){
        Empresa empresa = new Empresa();
        empresa.setUuid(UUID.randomUUID());
        empresa.setUser(user);
        empresa.setCnpj(empresaDTO.cnpj());
        empresa.setNomeFantasia(empresaDTO.nome_fantasia());
        empresa.setInscricaoEstadual(empresaDTO.inscricaoEstadual());
        empresa.setDescricao(empresaDTO.descricao());


        return empresa;
    }
}
