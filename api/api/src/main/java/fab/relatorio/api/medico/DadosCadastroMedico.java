package fab.relatorio.api.medico;

import fab.relatorio.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotBlank //Validação para que não receba dados nulos ou vazios -> válido para STRINGS
        String nome,

        @NotBlank
        @Email //Validar o formato de e-mail
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp="\\d{4,6}") //Validar de acordo com o padrão escrito em Regex
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid //validar anotações do Bean Validation dentro do DadosEndereco
        DadosEndereco endereco

) {
}
