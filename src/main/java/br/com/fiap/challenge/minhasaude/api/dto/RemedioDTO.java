package br.com.fiap.challenge.minhasaude.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RemedioDTO {
    private Long id;
    private String nome;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private Integer interval;
    private Integer qtdDose;
    private UsuarioDTO usuarioDTO;
}
