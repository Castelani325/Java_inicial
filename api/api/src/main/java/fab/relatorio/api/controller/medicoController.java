package fab.relatorio.api.controller;


import fab.relatorio.api.Domain.medico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class medicoController {

    @Autowired //perguntar ao chatgpt
    private MedicoRepository repository; //perguntar ao chatgpt

    @PostMapping
    @Transactional //Se tudo der certo, todas as alterações serão confirmadas (commit).
    public ResponseEntity cadastrar (@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) { // è usado o código HTTP 201

        var medico = new Medico(dados);

        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri(); //é o endereço onde a api está funcionando (localhost)


        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemMedicos>> listar(@PageableDefault(size = 20, page = 0, sort = {"nome","crm"} ) Pageable paginacao)  {
        //seria tipo List se não tivesse a paginação (Page)
        //return repository.findAll(); retornaria todos os dados da lista DE MÉDICOS CADASTRADOS

        //return repository.findAll(paginacao).map(DadosListagemMedicos::new);
        //repository.findAll() -> pega todas as entidades do banco e devolve uma List<Medico>.
        //.stream() -> transforma essa lista num Stream para processamento funcional.
        //map(...) -> percorre cada elemento do stream, aplicando a função passada.
        //DadosListagemMedicos::new -> é uma constructor reference: para cada Medico executa new DadosListagemMedicos(medico).
        //toList() -> é usado para converter um Stream em uma List de forma simples e direta.

        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
        return ResponseEntity.ok(page); //Continua vindo o codigo 200, mas agora vem o corpo do registro na resposta


        //Para haver ordenação dos dados na url, basta usar da seguinte forma : http://localhost:8080/medicos?sort=nome
        //Para que haja paginação, basta utilizar da seguinte foram na url : http://localhost:8080/medicos?size=2&page=0
        // Usar ",desc" para ordenar de fora decrescente
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarinformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));

    }

    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity excluir (@PathVariable Long id) { //ResponseEntity é uma boa prática para resposta de método Delete
        //repository.deleteById(id); DELETA DO BD
        var medico = repository.getReferenceById(id); // Realiza apenas a troca da variavel "Ativo" de True para False
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/{id}")
    //@Secured("ROLE_ADMIN") -> Também cria um filtro de métodos de acordo com o perfil do usuario logado
    public ResponseEntity Detalhar (@PathVariable Long id) { //ResponseEntity é uma boa prática para resposta de método Delete
        var medico = repository.getReferenceById(id); // Realiza apenas a troca da variavel "Ativo" de True para False

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

}
