package fab.relatorio.api.Domain.Consulta.Validacoes;

import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import jakarta.validation.ValidationException;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia {
    public void validar (DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos< 30) {
            throw new ValidationException ("Consulta deve ser agendada com, no mínimo, 30 minutos de antecedência  ");
        }
    }

}
