package br.com.fiap.challenge.minhasaude.api.controller;

import br.com.fiap.challenge.minhasaude.domain.entity.Remedio;
import br.com.fiap.challenge.minhasaude.domain.service.RemedioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class RemedioController {
    private final RemedioService service;

    public RemedioController(RemedioService service) {
        this.service = service;
    }

    @GetMapping("/active")
    public List<Remedio> allInUseByUser(@RequestParam("userId") Long userId) {
        return service.getAllInUseByUser(userId);
    }
}
