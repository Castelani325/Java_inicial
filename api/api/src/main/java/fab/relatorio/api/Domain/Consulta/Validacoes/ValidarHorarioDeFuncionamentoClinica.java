package fab.relatorio.api.Domain.Consulta.Validacoes;

import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidarHorarioDeFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar (DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domingo =  dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var antesDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDaAberturaDaClinica || antesDoEncerramentoDaClinica){
            throw new ValidationException("Consulta fora do horário permitido");
        }
    }

}
