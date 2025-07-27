package fab.relatorio.api.Domain.Consulta.Validacoes;

import fab.relatorio.api.Domain.Consulta.ConsultaRepository;
import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import jakarta.validation.ValidationException;

public class ValidadorSeConsultaNoMesmoHorario {

    private ConsultaRepository repository;

    public void validar (DadosAgendamentoConsulta dados){
        boolean medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidationException("Médico já possui outra consulta marcada para esse horário");
        }


    }

}
