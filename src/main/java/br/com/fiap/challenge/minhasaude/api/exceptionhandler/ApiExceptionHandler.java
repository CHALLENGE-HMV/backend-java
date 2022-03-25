package br.com.fiap.challenge.minhasaude.api.exceptionhandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiExceptionHandler extends RuntimeException {
    private final HttpStatus _status;
    private final String _message;

    public ApiExceptionHandler(HttpStatus status, String message){
        super();
        this._status = status;
        this._message = message;
    }
}
