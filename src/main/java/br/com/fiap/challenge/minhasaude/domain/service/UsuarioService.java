package br.com.fiap.challenge.minhasaude.domain.service;

import br.com.fiap.challenge.minhasaude.api.dto.UsuarioDTO;
import br.com.fiap.challenge.minhasaude.api.exceptionhandler.ApiErrorException;
import br.com.fiap.challenge.minhasaude.domain.entity.Usuario;
import br.com.fiap.challenge.minhasaude.domain.exception.NegocioException;
import br.com.fiap.challenge.minhasaude.domain.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final PasswordEncoder _passwordEncoder;
    private final UsuarioRepository repository;
    private final ConsultaService consultaService;

    public UsuarioService(UsuarioRepository repository, ConsultaService consultaService, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.consultaService = consultaService;
        this._passwordEncoder = passwordEncoder;
    }

    public Usuario registrar(Usuario usuario) throws ApiErrorException {
        if (repository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new NegocioException("E-mail já cadastrado");
        }
        usuario.setSenha(_passwordEncoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }

}
