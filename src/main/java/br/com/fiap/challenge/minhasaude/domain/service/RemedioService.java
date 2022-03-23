package br.com.fiap.challenge.minhasaude.domain.service;

import br.com.fiap.challenge.minhasaude.domain.entity.Remedio;
import br.com.fiap.challenge.minhasaude.domain.repository.RemedioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemedioService {
    private final RemedioRepository repository;

    public RemedioService(RemedioRepository repository) {
        this.repository = repository;
    }

    public List<Remedio> getAllInUseByUser(Long userId) {
        return repository.findAllInUseByUser(userId);
    }
}
