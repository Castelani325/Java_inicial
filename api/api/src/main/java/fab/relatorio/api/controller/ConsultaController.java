package fab.relatorio.api.controller;


import fab.relatorio.api.Domain.Consulta.AgendaDeConsultas;
import fab.relatorio.api.Domain.Consulta.DadosAgendamentoConsulta;
import fab.relatorio.api.Domain.Consulta.DadosCancelamentoConsulta;
import fab.relatorio.api.Domain.Consulta.DadosDetalhamentoConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid DadosAgendamentoConsulta dados) {

        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);

    };


    @DeleteMapping
    @Transactional
    // @Valid serve para que o spring verifique se as caracteristicas dos dados estão sendo respeitadas : notull, size, email...
    public ResponseEntity cancelar (@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agenda.cancelar (dados);
        return ResponseEntity.noContent().build();

    };
}
