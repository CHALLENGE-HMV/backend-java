package br.com.fiap.challenge.minhasaude.domain.repository;

import br.com.fiap.challenge.minhasaude.domain.entity.Atividade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AtividadeRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private AtividadeRepository atividadeRepository;

    private Atividade atividade;

    @BeforeEach
    public void setup() {
        atividade = new Atividade();
    }

    @Test
    public void deveSalvarUmaAtividade(){
        atividadeRepository.save(atividade);
        assertNotNull(atividade.getId());
    }

    @Test
    public void deveBuscarUmaAtividade() {
        atividadeRepository.save(atividade);
        Optional<Atividade> atividadeDb = atividadeRepository.findById(atividade.getId());
        assertTrue(atividadeDb.isPresent());
    }

    @Test
    public void deveDeletarUmaAtividade() {
        atividadeRepository.save(atividade);
        assertFalse(atividadeRepository.findAll().isEmpty());
        atividadeRepository.delete(atividade);
        assertTrue(atividadeRepository.findAll().isEmpty());
    }

    @Test
    public void deveAtualizarUmaAtividade() {
        atividadeRepository.save(atividade);
        String descricao = "Natação";
        atividade.setDescricao(descricao);
        atividadeRepository.save(atividade);
        Optional<Atividade> atividadeDb = atividadeRepository.findById(atividade.getId());
        assertTrue(atividadeDb.isPresent());
        assertEquals(descricao, atividadeDb.get().getDescricao());
    }
}
