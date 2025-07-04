//DadosCadastroPaciente
package fab.relatorio.api.paciente;


import fab.relatorio.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosCadastroPaciente (
    @NotBlank String nome,
    @NotBlank @Email String email,
    @NotBlank String telefone,
    @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "CPF inválido") String cpf,


    @NotNull
    @Valid
    DadosEndereco endereco


){}
