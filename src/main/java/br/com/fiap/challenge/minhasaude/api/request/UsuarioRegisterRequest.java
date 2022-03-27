package br.com.fiap.challenge.minhasaude.api.request;

import br.com.fiap.challenge.minhasaude.domain.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRegisterRequest {
    private String email;
    private String senha;
    private String nome;

    public Usuario toEntity() {
        return Usuario.builder()
                .nome(getNome())
                .email(getEmail())
                .senha(getSenha())
                .build();
    }
}
