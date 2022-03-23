package br.com.fiap.challenge.minhasaude.api.controller;

import br.com.fiap.challenge.minhasaude.domain.entity.Atividade;
import br.com.fiap.challenge.minhasaude.domain.service.AtividadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class AtividadeController {
    private final AtividadeService service;

    public AtividadeController(AtividadeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Atividade> allByUser(@RequestParam("userId") Long userId) {
        return service.getAllByUser(userId);
    }
}
