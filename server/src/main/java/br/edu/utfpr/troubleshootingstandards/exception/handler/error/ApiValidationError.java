package br.edu.utfpr.troubleshootingstandards.exception.handler.error;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;
}
