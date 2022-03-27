package br.com.fiap.challenge.minhasaude.api.controller;

import br.com.fiap.challenge.minhasaude.api.dto.UsuarioDTO;
import br.com.fiap.challenge.minhasaude.api.exceptionhandler.ApiErrorException;
import br.com.fiap.challenge.minhasaude.api.request.UsuarioRegisterRequest;
import br.com.fiap.challenge.minhasaude.api.response.UsuarioResponse;
import br.com.fiap.challenge.minhasaude.domain.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    private final UsuarioService _usuarioServiceservice;

    public UsuarioController(UsuarioService usuarioServiceservice) {
        this._usuarioServiceservice = usuarioServiceservice;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioRegisterRequest usuarioRegisterRequest) {
        try {
            var savedUser = _usuarioServiceservice.registrar(usuarioRegisterRequest.toEntity());
            URI location = URI.create(String.format("/users/%s", savedUser.getId()));
            return ResponseEntity.created(location).body(savedUser.toResponse());
        } catch (ApiErrorException e) {
            e.printStackTrace();
            return ResponseEntity.status(e.getStatus()).header(e.getMessage()).build();
        }
    }
    
}
