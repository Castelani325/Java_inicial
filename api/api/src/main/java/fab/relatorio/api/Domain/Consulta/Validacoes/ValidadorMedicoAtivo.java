package fab.relatorio.api.Domain.Consulta.Validacoes;

import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import fab.relatorio.api.Domain.medico.MedicoRepository;
import jakarta.validation.ValidationException;

public class ValidadorMedicoAtivo {

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
