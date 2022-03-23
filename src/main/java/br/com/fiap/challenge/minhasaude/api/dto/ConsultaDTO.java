package br.com.fiap.challenge.minhasaude.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {
    private Long id;
    private String medico;
    private String especialidade;
    private LocalDateTime dataHora;
    private UsuarioDTO usuarioDTO;
}
