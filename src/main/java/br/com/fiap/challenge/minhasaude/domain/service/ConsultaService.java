package br.com.fiap.challenge.minhasaude.domain.service;

import br.com.fiap.challenge.minhasaude.domain.entity.Consulta;
import br.com.fiap.challenge.minhasaude.domain.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<Consulta> getAllAgendadasByUser(Long userId, final int ano) {
        return repository.findAllAgendadasByUser(userId).stream()
                .filter(consulta -> consulta.getDataHora().getYear() == ano).
                collect(Collectors.toList());
    }

    public List<Consulta> getAllRealizadasByUser(Long userId, final int ano) {
        return repository.findAllRealizadasByUser(userId).stream()
                .filter(consulta -> consulta.getDataHora().getYear() == ano).
                collect(Collectors.toList());
    }

    public LocalDate getDataUltimaConsultaRealizadaByUser(Long userId) {
        Optional<Consulta> consultaOptional = repository.findAllRealizadasByUser(userId).stream().findFirst();
        return consultaOptional.map(consulta -> consulta.getDataHora().toLocalDate()).orElse(null);
    }

    public LocalDate getDataProximaConsultaAgendadaByUser(Long userId) {
        Optional<Consulta> consultaOptional = repository.findAllAgendadasByUser(userId).stream().findFirst();
        return consultaOptional.map(consulta -> consulta.getDataHora().toLocalDate()).orElse(null);
    }
}
