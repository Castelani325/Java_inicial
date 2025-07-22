package fab.relatorio.api.Domain.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
