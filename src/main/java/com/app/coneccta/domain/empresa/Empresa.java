package com.app.coneccta.domain.empresa;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empresa {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, updatable = false)
    private UUID uuid;

    @Column(name = "user_id", nullable = false, unique = true)
    private UUID userId;

    @Column(nullable = false)
    private String nome_fantasia;

    @Column(unique = true, nullable = false)
    private String cnpj;

    @Column(name ="inscricao_estadual" , unique = true)
    private String inscricaoEstadual;

    private String descricao;


    @Column(name = "created_at", columnDefinition = "DATETIME")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at",columnDefinition = "DATETIME")
    private OffsetDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = OffsetDateTime.now(ZoneOffset.UTC);
        this.updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
    }

}
