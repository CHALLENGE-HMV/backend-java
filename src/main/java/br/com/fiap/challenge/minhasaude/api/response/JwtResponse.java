package br.com.fiap.challenge.minhasaude.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class JwtResponse {
    private String access_token;
    private String email;
    private String type;
}
