package org.example.pdvapi.controllers;


import jakarta.validation.Valid;
import org.example.pdvapi.dto.AuthenticationDTO;
import org.example.pdvapi.dto.LoginResponseDTO;
import org.example.pdvapi.dto.RegistrarUsuarioDTO;
import org.example.pdvapi.interfaces.IAuthenticationController;
import org.example.pdvapi.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController implements IAuthenticationController {

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        System.out.println(authenticationDTO.login() + " " + authenticationDTO.senha());
        return authorizationService.login(authenticationDTO);
    }

    @Override
    public ResponseEntity<String> registrar(@RequestBody @Valid RegistrarUsuarioDTO usuario) {
        return authorizationService.registrarUsuario(usuario);
    }


}
