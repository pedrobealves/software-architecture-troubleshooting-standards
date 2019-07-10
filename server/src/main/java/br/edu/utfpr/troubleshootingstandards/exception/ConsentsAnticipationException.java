package br.edu.utfpr.troubleshootingstandards.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
public class ConsentsAnticipationException extends Exception {
    private String fieldName;

    public ConsentsAnticipationException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }
}
