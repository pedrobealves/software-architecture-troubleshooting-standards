package br.edu.utfpr.troubleshootingstandards.exception;

import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import lombok.Data;

@Data
public class ExceededAntecipationClassException extends Exception {

    private String fieldName;

    public ExceededAntecipationClassException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }
}
