package fab.relatorio.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //classe que lida com exceptions
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class) //quando o preenchimento não encontrar retorno
    public ResponseEntity tratarErros404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //quando há algum campo preenchido inválido
    public ResponseEntity tratarErros400(MethodArgumentNotValidException exception) {

        var erros = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(dadosErroValidacao::new).toList());
    }


    private record dadosErroValidacao (String campo, String mensagem) {
        public dadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }

    }


}
