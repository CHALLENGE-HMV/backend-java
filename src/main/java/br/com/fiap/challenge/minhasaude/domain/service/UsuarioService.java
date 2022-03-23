package br.com.fiap.challenge.minhasaude.domain.service;

import br.com.fiap.challenge.minhasaude.api.dto.UsuarioDTO;
import br.com.fiap.challenge.minhasaude.domain.entity.Usuario;
import br.com.fiap.challenge.minhasaude.domain.exception.NegocioException;
import br.com.fiap.challenge.minhasaude.domain.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public UsuarioDTO registrar(UsuarioDTO usuarioDTO) {
        if (repository.findByEmail(usuarioDTO.getEmail()).isPresent()) {
            throw new NegocioException("E-mail já cadastrado");
        }

        Usuario usuario = toUsuario(usuarioDTO);
        return toUsuarioDTO(repository.save(usuario));
    }

    public UsuarioDTO login(UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOptional = repository.findByEmailAndSenha(usuarioDTO.getEmail(), usuarioDTO.getSenha());
        if (usuarioOptional.isEmpty()) {
            throw new NegocioException("Usuário ou senha incorretos");
        }
        return toUsuarioDTO(usuarioOptional.get());
    }

    private Usuario toUsuario(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }

    private UsuarioDTO toUsuarioDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
}
