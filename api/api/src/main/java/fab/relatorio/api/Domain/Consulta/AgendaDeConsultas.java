package fab.relatorio.api.Domain.Consulta;


import fab.relatorio.api.Domain.medico.Medico;
import fab.relatorio.api.Domain.medico.MedicoRepository;
import fab.relatorio.api.Domain.paciente.Paciente;
import fab.relatorio.api.Domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Executa as regras de negocio e validacao da aplicacao
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;



    public void agendar (DadosAgendamentoConsulta dados){

        var medico = medicoRepository.findById(dados.idMedico()).get();
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
    }
}
