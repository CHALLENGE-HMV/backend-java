package br.com.fiap.challenge.minhasaude.api.controller;

import br.com.fiap.challenge.minhasaude.api.dto.UsuarioDTO;
import br.com.fiap.challenge.minhasaude.api.exceptionhandler.ApiErrorException;
import br.com.fiap.challenge.minhasaude.api.request.UsuarioRegisterRequest;
import br.com.fiap.challenge.minhasaude.api.response.UsuarioResponse;
import br.com.fiap.challenge.minhasaude.domain.entity.Usuario;
import br.com.fiap.challenge.minhasaude.domain.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    private final UsuarioService _usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this._usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioRegisterRequest usuarioRegisterRequest) {
        try {
            var savedUser = _usuarioService.registrar(usuarioRegisterRequest.toEntity());
            URI location = URI.create(String.format("/users/%s", savedUser.getId()));
            return ResponseEntity.created(location).body(savedUser.toResponse());
        } catch (ApiErrorException e) {
            e.printStackTrace();
            return ResponseEntity.status(e.getStatus()).header(e.getMessage()).build();
        }
    }

    @ApiOperation(value = "Find user email")
    @GetMapping("/{email}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable final String email) {
        try {
            var user =  _usuarioService.findByEmail(email);
            return ResponseEntity.ok().body(user.toResponse());
        } catch (ApiErrorException e) {
            e.printStackTrace();
            return ResponseEntity.status(e.getStatus()).header(e.getMessage()).build();
        }
    }
    
}
