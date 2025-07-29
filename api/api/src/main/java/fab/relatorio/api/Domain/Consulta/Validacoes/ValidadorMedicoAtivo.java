package fab.relatorio.api.Domain.Consulta.Validacoes;

import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import fab.relatorio.api.Domain.medico.MedicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar (DadosAgendamentoConsulta dados) {
        //Escolha do medico opcional
        if (dados.idMedico() == null) {
            return;
        }


        boolean medicoEstaAtivo = repository.findAtivoById (dados.idMedico());
        if (!medicoEstaAtivo){
            throw new ValidationException("Consulta não pode ser agendada com médio excluido");
        }

    }

}
