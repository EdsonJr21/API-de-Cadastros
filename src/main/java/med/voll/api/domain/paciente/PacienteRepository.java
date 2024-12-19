package med.voll.api.domain.paciente;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);

    @Query("SELECT COUNT(c) FROM Consulta c WHERE c.paciente.id = :idPaciente AND c.data = :data")
    boolean existsByIdPacienteIdAndData(@NotNull Long idPaciente, @NotNull @Future LocalDateTime data);

}
