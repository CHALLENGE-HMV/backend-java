package br.com.fiap.challenge.minhasaude.domain.repository;

import br.com.fiap.challenge.minhasaude.domain.entity.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    @Query("SELECT r FROM Remedio r WHERE r.usuario.id = :userId AND r.dataHoraFim < CURRENT_TIMESTAMP()")
    List<Remedio> findAllInUseByUser(@Param("userId") Long userId);
}
