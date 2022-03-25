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
public class LoginRequest {
    private String username;
    private String password;

    public Usuario toEntity() {
        return Usuario.builder()
                .email(getUsername())
                .senha(getPassword())
                .build();
    }

}
