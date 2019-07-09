package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.EntityNotFoundException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AnticipationService {

    void include(ProposalAnticipationDTO anticipationDTO) throws ExceededAntecipationClassException, DateAnticipationException;

    List<ProposalAnticipationDTO> getAll();

    Optional<ProposalAnticipationDTO> getById(Long id) throws EntityNotFoundException;

    Optional<ApprovalAnticipationDTO> getByIdApproval(Long id);

    void delete(Long id);
}
