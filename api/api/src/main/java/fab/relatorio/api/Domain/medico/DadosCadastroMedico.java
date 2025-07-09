package fab.relatorio.api.Domain.medico;

import fab.relatorio.api.Domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotBlank (message = "Nome obrigatório") //Validação para que não receba dados nulos ou vazios -> válido para STRINGS
        String nome,

        @NotBlank (message = "Email obrigatório")
        @Email //Validar o formato de e-mail
        String email,

        @NotBlank (message = "Telefone obrigatório")
        String telefone,

        @NotBlank (message = "CRM obrigatório")
        @Pattern(regexp="\\d{4,6}") //Validar de acordo com o padrão escrito em Regex
        String crm,

        @NotNull (message = "Especialidade obrigatória")
        Especialidade especialidade,

        @NotNull (message = "Dados de endereço são obrigatórios")
        @Valid //validar anotações do Bean Validation dentro do DadosEndereco
        DadosEndereco endereco

) {
}
