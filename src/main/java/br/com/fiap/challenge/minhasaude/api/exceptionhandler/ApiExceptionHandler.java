package br.com.fiap.challenge.minhasaude.api.exceptionhandler;

import br.com.fiap.challenge.minhasaude.domain.exception.NegocioException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest web) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Problema problem = Problema.builder().status(status.value()).titulo(ex.getMessage()).dataHora(OffsetDateTime.now()).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, web);
    }
}
