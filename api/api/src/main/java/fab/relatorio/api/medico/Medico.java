package fab.relatorio.api.medico;

import fab.relatorio.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Define que essa classe será mapeada para a tabela "medicos" no banco de dados
@Table(name = "medicos")

// Indica que esta classe é uma entidade JPA (será uma tabela no banco)
@Entity(name = "Medico")

// As anotações a seguir são usuais quando criando uma nova classe
@Getter                          // Lombok: gera automaticamente os métodos get para todos os atributos
@NoArgsConstructor               // Lombok: gera um construtor padrão (sem argumentos)
@AllArgsConstructor              // Lombok: gera um construtor com todos os campos como parâmetros
@EqualsAndHashCode(of = "id")   // Lombok: gera equals e hashCode usando apenas o campo "id"


// É uma entidade : É uma entidade JPA, ou seja, representa uma tabela com uma chave primária (id)
public class Medico {

    // Marca este campo como a chave primária da tabela
    @Id

    // Define que o valor da chave primária será gerado automaticamente (autoincremento)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;

    // Mapeia o enum para ser salvo como texto no banco (e não como número)
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    // Indica que o campo 'endereco' é um objeto embutido (suas colunas serão incorporadas à tabela 'medicos')
    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());

    }
}
