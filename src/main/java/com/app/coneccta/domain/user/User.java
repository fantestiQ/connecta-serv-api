package com.app.coneccta.domain.user;


import com.app.coneccta.domain.enderecos.Endereco;
import com.app.coneccta.domain.listeners.DatesBase;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "User")
@Setter(AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class User extends DatesBase implements UserDetails {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true, updatable = false, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

   public static User  createUserEmpresa(UserDTO userDTO) {
        User empresaUser = new User();
        empresaUser.setNome(userDTO.name()) ;
        empresaUser.setUuid(UUID.randomUUID());
        empresaUser.setEmail(userDTO.email());
        empresaUser.setPassword(userDTO.password());
        empresaUser.setTelefone(userDTO.telefone());
        empresaUser.setRole(Role.EMPRESA);

        if (userDTO.Enderecos() != null){
            userDTO.Enderecos().forEach(empresaUser::addEndereco);
        }

        return empresaUser;
    }
    public static User  createUserCandidato(UserDTO userDTO) {
        User userCandidato = new User();
        userCandidato.setNome(userDTO.name());
        userCandidato.setUuid(UUID.randomUUID());
        userCandidato.setEmail(userDTO.email());
        userCandidato.setPassword(userDTO.password());
        userCandidato.setTelefone(userDTO.telefone());
        userCandidato.setRole(Role.CANDIDATO);
        if (userDTO.Enderecos() != null){
            userDTO.Enderecos().forEach(userCandidato::addEndereco);
        }

        return userCandidato;
    }

    public void addEndereco(Endereco endereco){
       this.enderecos.add(endereco);
       endereco.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telefone='" + telefone + '\'' +
                ", role=" + role +
                ", enderecos=" + enderecos +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public  String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
