package fab.relatorio.api.Domain.paciente;

import fab.relatorio.api.Domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String cpf, String telefone, Endereco endereco ) {

    //Construtor
    public DadosDetalhamentoPaciente (Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(),paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());

    }

}
