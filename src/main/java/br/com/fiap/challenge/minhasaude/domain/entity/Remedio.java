package br.com.fiap.challenge.minhasaude.domain.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private Integer intervalo;
    private Integer qtdDose;

    @ManyToOne
    private Usuario usuario;
}
