package fab.relatorio.api.Domain.paciente;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);


    //Está incompleto
    Object findAtivoById(@NotNull Long idPaciente);
}
