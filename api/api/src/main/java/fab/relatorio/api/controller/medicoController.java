package fab.relatorio.api.controller;


import fab.relatorio.api.endereco.Endereco;
import fab.relatorio.api.medico.DadosCadastroMedico;
import fab.relatorio.api.medico.Medico;
import fab.relatorio.api.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class medicoController {

    @Autowired //perguntar ao chatgpt
    private MedicoRepository repository; //perguntar ao chatgpt

    @PostMapping
    @Transactional //Se tudo der certo, todas as alterações serão confirmadas (commit).
    public void cadastrar (@RequestBody DadosCadastroMedico dados) {

        repository.save(new Medico(dados));


    }

}
