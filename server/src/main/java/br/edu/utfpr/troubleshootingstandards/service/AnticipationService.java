package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.entity.Modalitie;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AnticipationService {

    void include(ProposalAnticipationDTO anticipationDTO) throws ExceededAntecipationClassException, DateAnticipationException;

    List<ProposalAnticipationDTO> getAll();

    Optional<ProposalAnticipationDTO> getById(Long id);

    void delete(Long id);
}