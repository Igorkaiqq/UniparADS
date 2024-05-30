package org.example.pdvapi.services;

import jakarta.validation.Valid;
import org.example.pdvapi.dto.AuthenticationDTO;
import org.example.pdvapi.dto.LoginResponseDTO;
import org.example.pdvapi.dto.RegistrarUsuarioDTO;
import org.example.pdvapi.entity.UsuarioEntity;
import org.example.pdvapi.infra.security.TokenService;
import org.example.pdvapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthorizationService(@Lazy AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(username);
    }

    public ResponseEntity<String> login(@Valid AuthenticationDTO authenticationDTO) {
        authenticationManager = applicationContext.getBean(AuthenticationManager.class);
        var usuarioSenha = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.senha());
        var auth = this.authenticationManager.authenticate(usuarioSenha);
        if (auth.isAuthenticated()) {
            var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(token).token());
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<String> registrarUsuario(RegistrarUsuarioDTO usuario) {
        if (usuarioRepository.findByLogin(usuario.login()) != null || usuarioRepository.findByEmail(usuario.email()) != null){
            return ResponseEntity.badRequest().build();
        }
        String senhaEncriptografada = new BCryptPasswordEncoder().encode(usuario.senha());
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario.nome(), usuario.email(), usuario.login(), senhaEncriptografada, usuario.permissao());
        usuarioRepository.save(usuarioEntity);
        return ResponseEntity.ok().build();
    }
}
