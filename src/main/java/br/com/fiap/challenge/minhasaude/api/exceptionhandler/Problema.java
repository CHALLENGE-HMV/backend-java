package br.com.fiap.challenge.minhasaude.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Problema {
    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Campo> campos;

    @Data
    @Builder
    static class Campo {
        private String nome;
        private String mensagem;
    }
}
