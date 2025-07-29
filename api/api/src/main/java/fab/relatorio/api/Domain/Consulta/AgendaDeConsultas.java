package fab.relatorio.api.Domain.Consulta;


import fab.relatorio.api.Domain.Consulta.Validacoes.ValidadorAgendamentoDeConsulta;
import fab.relatorio.api.Domain.medico.Medico;
import fab.relatorio.api.Domain.medico.MedicoRepository;
import fab.relatorio.api.Domain.paciente.Paciente;
import fab.relatorio.api.Domain.paciente.PacienteRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Executa as regras de negocio e validacao da aplicacao
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;


    public void agendar (DadosAgendamentoConsulta dados){



        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidationException("Id do médico informado não existe!");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        if (medico == null) {
            throw new ValidationException("Não existe médico disponível nessa data!");
        }

        var consulta = new Consulta(null, null, medico, paciente, dados.data() );
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico (DadosAgendamentoConsulta dados){
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidationException("Especialidade obrigatória quando médico não especificado.");
        }

        return medicoRepository.escolherMedicosAleatorioLivreNaData(dados.especialidade(), dados.data());
    };

    public void cancelar (DadosCancelamentoConsulta dados) {

        if (!consultaRepository.existsById(dados.idConsulta())){
            throw new ValidationException("id da Consulta informado não existe");
        }
        
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }
}
