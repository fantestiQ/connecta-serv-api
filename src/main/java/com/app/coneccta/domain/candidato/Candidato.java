package com.app.coneccta.domain.candidato;

import com.app.coneccta.domain.listeners.DatesBase;
import com.app.coneccta.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;



import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Entity(name = "Candidato")
@Table(name = "candidatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Candidato extends DatesBase {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, updatable = false, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false )
    private LocalDate dataNascimento;

    private String descricao;


    public static Candidato createCandidato(CanditatoDTO canditatoDTO, User user){
        Candidato candidato = new Candidato();

        candidato.setUser(user);
        candidato.setUuid(UUID.randomUUID());
        candidato.setCpf(canditatoDTO.cpf());
        candidato.setDataNascimento(canditatoDTO.dataNascimento());
        candidato.setDescricao(canditatoDTO.descricao());
        return candidato;
    }
}
