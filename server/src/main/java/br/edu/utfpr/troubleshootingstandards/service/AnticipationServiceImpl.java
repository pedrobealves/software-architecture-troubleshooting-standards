package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.EntityNotFoundException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.model.*;
import br.edu.utfpr.troubleshootingstandards.repository.ProposalAnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.service.mapper.AnticipationMapper;
import br.edu.utfpr.troubleshootingstandards.service.mapper.ApprovalAnticipationMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class AnticipationServiceImpl implements AnticipationService {

    @Autowired
    private ProposalAnticipationRepository anticipationRepository;

    @Autowired
    private AnticipationMapper anticipationMapper;

    @Autowired
    private ApprovalAnticipationMapper approvalAnticipationMapper;

    /**
     *
     * @param proposalAnticipationDTO
     * @throws ExceededAntecipationClassException
     * @throws DateAnticipationException
     * function to create new antecipation on system, with rules and exceptions
     */
    @Override
    public void include(ProposalAnticipationDTO proposalAnticipationDTO) throws ExceededAntecipationClassException, DateAnticipationException {

        //Regra de negócio sobre número de aulas
        if (proposalAnticipationDTO.getAnticipation().getNumberClasses() > 6)
            throw new ExceededAntecipationClassException(
                    "Número de aulas excedido",
                    "anticipation.numberClasses"
            );

        //Regra sobre data de antecipação de aula
        if(proposalAnticipationDTO.getAnticipation().getNextDate().isAfter(proposalAnticipationDTO.getLesson().getDate()))
            throw new ExceededAntecipationClassException(
                    "Data deve ser anterior à data e ao horário previsto no plano de ensino",
                    "anticipation.nextDate"
            );

        anticipationRepository
                .save(
                        anticipationMapper
                                .toProposalAnticipation(proposalAnticipationDTO)
                );

    }

    @Override
    // delete specific antecipation
    public void delete(Long id) {
        anticipationRepository
                .deleteById(id);
    }

    @Override
    // returns list of all antecipations
    public List<ProposalAnticipationDTO> getAll() {
        return anticipationMapper.toProposalAnticipationDTO(anticipationRepository.findAll());
    }

    @Override
    // return specific antecipation or exception if id wrong
    public Optional<ProposalAnticipationDTO> getById(Long id) throws EntityNotFoundException {
        return Optional.ofNullable(anticipationRepository
                .findById(id)
                .map(a -> anticipationMapper.toProposalAnticipationDTO(a))
                .orElseThrow(() -> new EntityNotFoundException(ProposalAnticipation.class, "id", id.toString())));
    }

    @Override
    // return antecipation by approvalId
    public Optional<ApprovalAnticipationDTO> getByIdApproval(Long id) {
        return anticipationRepository
                .findById(id)
                .map(a -> approvalAnticipationMapper.toApprovalAnticipationDTO(a.getApprovalAnticipation()));
    }

}
