package br.com.fiap.challenge.minhasaude.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
public class UsuarioResponse {
    private Long id;

    private String nome;
    private String email;
    private Integer pontos;
    private String registro;
    private LocalDate dataNascimento;
}
