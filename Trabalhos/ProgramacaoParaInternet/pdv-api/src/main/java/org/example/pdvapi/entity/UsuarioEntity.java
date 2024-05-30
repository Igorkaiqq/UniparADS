package org.example.pdvapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.pdvapi.Enums.UsuariosPermissaoEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Usuario")
@Table(name = "Usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"user", "email"}))
@EqualsAndHashCode(of = "id")
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;
    @Column(name = "nome")
    public String nome;
    @Column(name = "email")
    public String email;
    @Column(name = "login")
    public String login;
    @Column(name = "senha")
    public String senha;
    @Enumerated(EnumType.STRING)
    @Column(name = "permissao")
    public UsuariosPermissaoEnum permissao;

    public UsuarioEntity(String nome, String email, String login, String senha, UsuariosPermissaoEnum permissao) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.permissao = permissao;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.permissao != UsuariosPermissaoEnum.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_USER"));

        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
