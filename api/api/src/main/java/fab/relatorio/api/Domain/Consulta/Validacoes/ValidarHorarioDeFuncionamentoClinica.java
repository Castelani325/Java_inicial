package fab.relatorio.api.Domain.Consulta.Validacoes;

import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import jakarta.validation.ValidationException;

import java.time.DayOfWeek;

public class ValidarHorarioDeFuncionamentoClinica {

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
