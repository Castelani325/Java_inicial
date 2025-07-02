package fab.relatorio.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository <Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao); //Tipo de atributo e Tipo de atributo da chave primária


}
