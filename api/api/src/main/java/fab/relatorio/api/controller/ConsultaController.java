package fab.relatorio.api.controller;


import fab.relatorio.api.Domain.Consulta.AgendaDeConsultas;
import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import fab.relatorio.api.Domain.Consulta.DadosDetalhamentoConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid DadosAgendamentoConsulta dados) {

        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null,null,null,null));

    };
}
