package org.example.pdvapi.controllers;


import jakarta.validation.Valid;
import org.example.pdvapi.dto.AuthenticationDTO;
import org.example.pdvapi.dto.RegistrarUsuarioDTO;
import org.example.pdvapi.interfaces.IAuthenticationController;
import org.example.pdvapi.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements IAuthenticationController {

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        return authorizationService.login(authenticationDTO);
    }

    @Override
    public ResponseEntity<String> registrar(@RequestBody @Valid RegistrarUsuarioDTO usuario) {
        return authorizationService.registrarUsuario(usuario);
    }


}
