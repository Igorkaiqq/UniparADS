package org.example.pdvapi.interfaces;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.pdvapi.dto.AuthenticationDTO;
import org.example.pdvapi.dto.RegistrarUsuarioDTO;
import org.example.pdvapi.entity.UsuarioEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Autenticação", description = "Endpoints de Autenticação")
@RequestMapping("/auth")
public interface IAuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO authenticationDTO);

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody @Valid RegistrarUsuarioDTO usuario);

}
