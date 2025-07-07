package fab.relatorio.api.controller;


import fab.relatorio.api.paciente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/pacientes")
public class pacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }


    @GetMapping
    public Page<DadosListagemPacientes> listar (@PageableDefault (size = 4, page = 0, sort = {"nome","cpf"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPacientes::new);

    }
    @DeleteMapping ("/{id}")
    @Transactional
    public void excluir (@PathVariable Long id) {

        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }

    // Criar metodo ATUALIZAR
    @PutMapping
    @Transactional
    public void atualizar (@RequestBody @Valid DadosAtualizarPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);

   }

}


