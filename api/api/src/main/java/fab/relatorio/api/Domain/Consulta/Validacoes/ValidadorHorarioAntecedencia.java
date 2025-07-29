package fab.relatorio.api.Domain.Consulta.Validacoes;

import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {
    public void validar (DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos< 30) {
            throw new ValidationException ("Consulta deve ser agendada com, no mínimo, 30 minutos de antecedência  ");
        }
    }

}
