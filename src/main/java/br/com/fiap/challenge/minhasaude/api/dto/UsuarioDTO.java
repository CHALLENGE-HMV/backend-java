package br.com.fiap.challenge.minhasaude.api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String registro;
    private Integer pontos;
    private LocalDate dataNascimento;
    private LocalDate dataProximaConsulta;
    private LocalDate dataUltimaConsulta;
}
