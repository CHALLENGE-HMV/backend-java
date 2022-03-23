package br.com.fiap.challenge.minhasaude.api.dto;

import lombok.Data;

@Data
public class AtividadeDTO {
    private Long id;
    private String descricao;
    private UsuarioDTO usuarioDTO;
}
