package fab.relatorio.api.Domain.Consulta.Validacoes;

import fab.relatorio.api.Domain.Consulta.ConsultaRepository;
import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import jakarta.validation.ValidationException;

public class ValidadoPacienteSemOutraConsultNoDia {

    private ConsultaRepository repository;

    public void  validar (DadosAgendamentoConsulta dados) {

        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);

        boolean pacientePossuiOutraConsultaNoDia = repository.existsPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidationException("Paciente já possui outro agendamento no mesmo dia.");
        }
    }
}
