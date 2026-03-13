package com.app.coneccta.domain.requests;

import com.app.coneccta.domain.candidato.CandidatoDTO;
import com.app.coneccta.domain.user.UserDTO;
import jakarta.validation.Valid;

public record RequestUserCandidato(
        @Valid UserDTO user,
         @Valid CandidatoDTO candidato
) {
}
