package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.entity.*;
import br.edu.utfpr.troubleshootingstandards.repository.AttendanceStudentRepository;
import br.edu.utfpr.troubleshootingstandards.repository.LessonRepository;
import br.edu.utfpr.troubleshootingstandards.repository.ProposalAnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.service.mapper.AnticipationMapper;
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

    /**
     *
     * @param proposalAnticipationDTO
     * @throws ExceededAntecipationClassException
     * @throws DateAnticipationException
     */
    @Override
    public void include(ProposalAnticipationDTO proposalAnticipationDTO) throws ExceededAntecipationClassException, DateAnticipationException {

        //Regra de negócio sobre número de aulas
        if (proposalAnticipationDTO.getAnticipation().getNumberClasses() > 6)
            throw new ExceededAntecipationClassException("Número de aulas excedido");

        //Regra sobre data de antecipação de aula
        if(proposalAnticipationDTO.getAnticipation().getNextDate().after(proposalAnticipationDTO.getLesson().getDate()))
            throw new DateAnticipationException("Data deve ser anterior à data e ao horário previsto no plano de ensino");

        anticipationRepository
                .save(
                        anticipationMapper
                                .toProposalAnticipation(proposalAnticipationDTO)
                );

    }

    @Override
    public void delete(Long id) {
        anticipationRepository
                .deleteById(id);
    }

    @Override
    public List<ProposalAnticipationDTO> getAll() {
        return anticipationMapper.toProposalAnticipationDTO(anticipationRepository.findAll());
    }

    @Override
    public Optional<ProposalAnticipationDTO> getById(Long id) {
        return anticipationRepository
                .findById(id)
                .map(a -> anticipationMapper.toProposalAnticipationDTO(a));

    }

}
