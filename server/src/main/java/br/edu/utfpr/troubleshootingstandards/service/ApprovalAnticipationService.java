package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.ConsentsAnticipationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ApprovalAnticipationService {
    void include(ApprovalAnticipationDTO approvalAnticipationDTO) throws ConsentsAnticipationException;
    Optional<ApprovalAnticipationDTO> getById(Long id);
    List<ApprovalAnticipationDTO> getAll();
}
