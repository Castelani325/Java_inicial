package fab.relatorio.api.paciente;

import fab.relatorio.api.endereco.DadosEndereco;
import fab.relatorio.api.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPaciente(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {}
