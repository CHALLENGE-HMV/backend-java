package br.com.fiap.challenge.minhasaude.domain.repository;

import br.com.fiap.challenge.minhasaude.domain.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("SELECT c FROM Consulta c WHERE c.usuario.id = :userId AND c.dataHora < CURRENT_TIMESTAMP() ORDER BY c.dataHora DESC")
    List<Consulta> findAllRealizadasByUser(@Param("userId") Long userId);

    @Query("SELECT c FROM Consulta c WHERE c.usuario.id = :userId AND c.dataHora >= CURRENT_TIMESTAMP() ORDER BY c.dataHora ASC")
    List<Consulta> findAllAgendadasByUser(@Param("userId") Long userId);
}
