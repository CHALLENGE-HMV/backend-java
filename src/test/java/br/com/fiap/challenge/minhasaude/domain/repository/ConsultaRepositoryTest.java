package br.com.fiap.challenge.minhasaude.domain.repository;

import br.com.fiap.challenge.minhasaude.domain.entity.Consulta;
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
public class ConsultaRepositoryTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ConsultaRepository consultaRepository;

    private Consulta consulta;

    @BeforeEach
    public void setup() {
        consulta = new Consulta();
    }

    @Test
    public void deveSalvarUmaConsulta(){
        consultaRepository.save(consulta);
        assertNotNull(consulta.getId());
    }

    @Test
    public void deveBuscarUmaConsulta() {
        consultaRepository.save(consulta);
        Optional<Consulta> consultaDb = consultaRepository.findById(consulta.getId());
        assertTrue(consultaDb.isPresent());
    }

    @Test
    public void deveDeletarUmaConsulta() {
        consultaRepository.save(consulta);
        assertFalse(consultaRepository.findAll().isEmpty());
        consultaRepository.delete(consulta);
        assertTrue(consultaRepository.findById(consulta.getId()).isEmpty());
    }

    @Test
    public void deveAtualizarUmaConsulta() {
        consultaRepository.save(consulta);
        String medico = "Cleiton";
        consulta.setMedico(medico);
        consultaRepository.save(consulta);
        Optional<Consulta> consultaDb = consultaRepository.findById(consulta.getId());
        assertTrue(consultaDb.isPresent());
        assertEquals(medico, consultaDb.get().getMedico());
    }
}
