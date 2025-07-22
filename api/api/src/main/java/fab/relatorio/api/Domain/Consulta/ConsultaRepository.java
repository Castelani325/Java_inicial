package fab.relatorio.api.Domain.Consulta;

import fab.relatorio.api.Domain.medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository <Consulta, Long> {
}
