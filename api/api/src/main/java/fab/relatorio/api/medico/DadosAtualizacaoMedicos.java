package fab.relatorio.api.medico;

import fab.relatorio.api.endereco.DadosEndereco;
import fab.relatorio.api.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicos(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {


}
