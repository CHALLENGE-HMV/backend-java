package br.com.fiap.challenge.minhasaude.domain.repository;

import br.com.fiap.challenge.minhasaude.domain.entity.Remedio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
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
    public void deveSalvarUmRemedio(){
        remedioRepository.save(remedio);
        assertNotNull(remedio.getId());
    }

    @Test
    public void deveBuscarUmRemedio() {
        remedioRepository.save(remedio);
        Optional<Remedio> remedioDb = remedioRepository.findById(remedio.getId());
        assertTrue(remedioDb.isPresent());
    }

    @Test
    public void deveDeletarUmRemedio() {
        remedioRepository.save(remedio);
        assertFalse(remedioRepository.findAll().isEmpty());
        remedioRepository.delete(remedio);
        assertTrue(remedioRepository.findById(remedio.getId()).isEmpty());
    }

    @Test
    public void deveAtualizarUmRemedio() {
        remedioRepository.save(remedio);
        String nome = "Novalgina";
        remedio.setNome(nome);
        remedioRepository.save(remedio);
        Optional<Remedio> remedioDb = remedioRepository.findById(remedio.getId());
        assertTrue(remedioDb.isPresent());
        assertEquals(nome, remedioDb.get().getNome());
    }
}
