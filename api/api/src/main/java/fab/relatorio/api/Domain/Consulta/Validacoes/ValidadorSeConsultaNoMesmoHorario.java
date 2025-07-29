package fab.relatorio.api.Domain.Consulta.Validacoes;

import fab.relatorio.api.Domain.Consulta.ConsultaRepository;
import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorSeConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar (DadosAgendamentoConsulta dados){
        boolean medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidationException("Médico já possui outra consulta marcada para esse horário");
        }


    }

}
