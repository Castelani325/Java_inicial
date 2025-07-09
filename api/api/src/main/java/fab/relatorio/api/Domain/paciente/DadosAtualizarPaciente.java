package fab.relatorio.api.Domain.paciente;

import fab.relatorio.api.Domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPaciente(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {}
