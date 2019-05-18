package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.model.*;
import br.edu.utfpr.troubleshootingstandards.repository.LessonRepository;
import br.edu.utfpr.troubleshootingstandards.repository.ProposalAnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.repository.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AnticipationServiceImpl implements AnticipationService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ProposalAnticipationRepository anticipationRepository;

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

        Lesson lesson = lessonRepository
                .findById(proposalAnticipationDTO.getLesson().getId())
                .orElseThrow(IllegalArgumentException::new);

        anticipationRepository.save(
                ProposalAnticipation
                        .builder()
                        .anticipation(anticipationDTOtoAnticipation(proposalAnticipationDTO.getAnticipation()))
                        .lesson(lesson)
                        .build()
        );

    }

    private Anticipation anticipationDTOtoAnticipation(AnticipationDTO anticipationDTO){
        return Anticipation
                .builder()
                .reason(Reason
                        .builder()
                        .reasonBy(ReasonBy.valueOf(anticipationDTO.getReason().getReasonBy()))
                        .description(anticipationDTO.getReason().getDescription())
                        .build()
                )
                .modalitie(
                        anticipationDTO.isInPerson() ?
                                Modalities.PRESENCIAL :
                                Modalities.NÃO_PRESENCIAL)
                .numberClasses(anticipationDTO.getNumberClasses())
                .nextDate(anticipationDTO.getNextDate())
                .build();
    }
}
