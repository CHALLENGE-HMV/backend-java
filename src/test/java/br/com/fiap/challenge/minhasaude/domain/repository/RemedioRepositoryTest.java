package br.com.fiap.challenge.minhasaude.domain.repository;

import br.com.fiap.challenge.minhasaude.domain.entity.Remedio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class RemedioRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private RemedioRepository remedioRepository;

    private Remedio remedio;

    @BeforeEach
    public void setup() {
        remedio = new Remedio();
    }

    @Test
    public void deveSalvarUmaRemedio(){
        remedioRepository.save(remedio);
        assertNotNull(remedio.getId());
    }

    @Test
    public void deveBuscarUmaRemedio() {
        remedioRepository.save(remedio);
        Optional<Remedio> remedioDb = remedioRepository.findById(remedio.getId());
        assertTrue(remedioDb.isPresent());
    }

    @Test
    public void deveDeletarUmaRemedio() {
        remedioRepository.save(remedio);
        assertFalse(remedioRepository.findAll().isEmpty());
        remedioRepository.delete(remedio);
        assertTrue(remedioRepository.findAll().isEmpty());
    }

    @Test
    public void deveAtualizarUmaRemedio() {
        remedioRepository.save(remedio);
        String nome = "Novalgina";
        remedio.setNome(nome);
        remedioRepository.save(remedio);
        Optional<Remedio> remedioDb = remedioRepository.findById(remedio.getId());
        assertTrue(remedioDb.isPresent());
        assertEquals(nome, remedioDb.get().getNome());
    }
}
