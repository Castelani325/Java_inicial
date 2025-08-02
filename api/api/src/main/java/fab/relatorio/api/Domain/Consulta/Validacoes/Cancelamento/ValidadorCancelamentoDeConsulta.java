package fab.relatorio.api.Domain.Consulta.Validacoes.Cancelamento;

import fab.relatorio.api.Domain.Consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);

}