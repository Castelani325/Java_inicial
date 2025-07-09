package fab.relatorio.api.Domain.medico;

import fab.relatorio.api.Domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicos(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {


}
