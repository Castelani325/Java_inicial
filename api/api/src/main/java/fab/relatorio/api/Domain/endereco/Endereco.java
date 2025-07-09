package fab.relatorio.api.Domain.endereco;

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

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro(); ;
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if(dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if(dados.cep() != null) {
            this.cep = dados.cep();
        }
        if(dados.numero() != null) {
            this.numero = dados.numero();
        }
        if(dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if(dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if(dados.uf() != null) {
            this.uf = dados.uf();
        }

    }
}
