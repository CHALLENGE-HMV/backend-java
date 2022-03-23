package br.com.fiap.challenge.minhasaude.domain.service;

import br.com.fiap.challenge.minhasaude.domain.entity.Atividade;
import br.com.fiap.challenge.minhasaude.domain.repository.AtividadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {
    private final AtividadeRepository repository;

    public AtividadeService(AtividadeRepository repository) {
        this.repository = repository;
    }

    public List<Atividade> getAllByUser(Long userId) {
        return repository.findAllByUsuarioId(userId);
    }
}
