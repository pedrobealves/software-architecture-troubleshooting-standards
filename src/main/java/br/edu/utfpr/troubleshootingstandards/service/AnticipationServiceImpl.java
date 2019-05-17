package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.model.*;
import br.edu.utfpr.troubleshootingstandards.repository.ProposalAnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.repository.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AnticipationServiceImpl implements AnticipationService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private ProposalAnticipationRepository anticipationRepository;

    /**
     *
     * @param anticipationDTO
     * @throws ExceededAntecipationClassException
     * @throws DateAnticipationException
     */
    @Override
    public void include(AnticipationDTO anticipationDTO) throws ExceededAntecipationClassException, DateAnticipationException {


        //Regra de negócio sobre número de aulas
        if (anticipationDTO.getNumberClasses() > 6)
            throw new ExceededAntecipationClassException("Número de aulas excedido");

        //Regra sobre data de antecipação de aula
        if(anticipationDTO.getDate().after(anticipationDTO.getPreviousDate()))
            throw new DateAnticipationException("Data deve ser anterior à data e ao horário previsto no plano de ensino");

        Lecturer lecturer = lecturerRepository
                .findById(anticipationDTO.getLecturer().getCode())
                .orElseThrow(IllegalArgumentException::new);

        anticipationRepository.save(
                Anticipation
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
                        .previousDate(anticipationDTO.getPreviousDate())
                        .date(anticipationDTO.getDate())
                        .lecturer(lecturer)
                        .build()
        );

    }
}
