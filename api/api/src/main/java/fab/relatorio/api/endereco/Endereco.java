package fab.relatorio.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable                      // Indica que esta classe pode ser "embutida" em outra entidade (como Medico), ou seja, suas colunas serão incorporadas à tabela principal
@Getter                          // Lombok: gera automaticamente os métodos get para todos os atributos
@NoArgsConstructor               // Lombok: gera um construtor padrão (sem argumentos)
@AllArgsConstructor              // Lombok: gera um construtor com todos os campos como parâmetros

// É um objeto embutido (Embedded) : É um valor embutido, não tem ID próprio nem representa uma tabela independente.
public class Endereco {


    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
}
