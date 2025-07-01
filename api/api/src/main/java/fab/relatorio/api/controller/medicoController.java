package fab.relatorio.api.controller;


import fab.relatorio.api.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class medicoController {

    @Autowired //perguntar ao chatgpt
    private MedicoRepository repository; //perguntar ao chatgpt

    @PostMapping
    @Transactional //Se tudo der certo, todas as alterações serão confirmadas (commit).
    public void cadastrar (@RequestBody @Valid DadosCadastroMedico dados) {

        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 2, page = 0, sort = {"nome","crm"} ) Pageable paginacao)  {
        //seria tipo List se não tivesse a paginação (Page)
        //return repository.findAll(); retornaria todos os dados da lista DE MÉDICOS CADASTRADOS

        return repository.findAll(paginacao).map(DadosListagemMedicos::new);
        //repository.findAll() -> pega todas as entidades do banco e devolve uma List<Medico>.
        //.stream() -> transforma essa lista num Stream para processamento funcional.
        //map(...) -> percorre cada elemento do stream, aplicando a função passada.
        //DadosListagemMedicos::new -> é uma constructor reference: para cada Medico executa new DadosListagemMedicos(medico).
        //toList() -> é usado para converter um Stream em uma List de forma simples e direta.


        //Para haver ordenação dos dados na url, basta usar da seguinte forma : http://localhost:8080/medicos?sort=nome
        //Para que haja paginação, basta utilizar da seguinte foram na url : http://localhost:8080/medicos?size=2&page=0
        // Usar ",desc" para ordenar de fora decrescente
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarinformacoes(dados);
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public void excluir (@PathVariable Long id) {
        repository.deleteById(id);
    }

}
