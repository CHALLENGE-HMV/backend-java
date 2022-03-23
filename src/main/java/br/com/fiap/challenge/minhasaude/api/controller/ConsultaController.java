package br.com.fiap.challenge.minhasaude.api.controller;

import br.com.fiap.challenge.minhasaude.domain.entity.Consulta;
import br.com.fiap.challenge.minhasaude.domain.service.ConsultaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class ConsultaController {
    private final ConsultaService service;

    public ConsultaController(ConsultaService consultaService) {
        this.service = consultaService;
    }

    @GetMapping("/scheduled")
    public List<Consulta> allAgendadasByUser(@RequestParam("userId") Long userId, @RequestParam("year") int ano) {
        return service.getAllAgendadasByUser(userId, ano);
    }

    @GetMapping("/done")
    public List<Consulta> allRealizadasByUser(@RequestParam("userId") Long userId, @RequestParam("year") int ano) {
        return service.getAllRealizadasByUser(userId, ano);
    }
}
