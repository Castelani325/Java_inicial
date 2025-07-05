package fab.relatorio.api.paciente;

import fab.relatorio.api.medico.Medico;

public record DadosListagemPacientes (Long id, String nome, String email, String cpf, String telefone){

    public DadosListagemPacientes(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }

}
