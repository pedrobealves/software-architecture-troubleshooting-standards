package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.model.Anticipation;
import br.edu.utfpr.troubleshootingstandards.model.Lecturer;
import br.edu.utfpr.troubleshootingstandards.model.Modalities;
import br.edu.utfpr.troubleshootingstandards.repository.AnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.repository.LecturerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class AnticipationServiceImpl implements AnticipationService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private AnticipationRepository anticipationRepository;

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
                .findByCode(anticipationDTO.getLecturer().getCode())
                .orElseThrow(IllegalArgumentException::new);

        anticipationRepository.save(
                Anticipation
                        .builder()
                        .reason(anticipationDTO.getReason())
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
