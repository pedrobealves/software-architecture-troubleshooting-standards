package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.ConsentsAnticipationException;
import org.springframework.stereotype.Service;

@Service
public interface ApprovalAnticipationService {
    void approval(ApprovalAnticipationDTO approvalAnticipationDTO) throws ConsentsAnticipationException;
}
