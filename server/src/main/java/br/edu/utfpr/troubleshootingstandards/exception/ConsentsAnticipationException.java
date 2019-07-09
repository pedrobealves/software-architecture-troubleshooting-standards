package br.edu.utfpr.troubleshootingstandards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ConsentsAnticipationException extends RuntimeException {
    public ConsentsAnticipationException(String message) {
        super(message);
    }
}
