package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.model.Anticipation;
import br.edu.utfpr.troubleshootingstandards.model.Lecturer;
import br.edu.utfpr.troubleshootingstandards.model.Modalities;
import br.edu.utfpr.troubleshootingstandards.repository.AnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnticipationServiceImpl implements AnticipationService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private AnticipationRepository anticipationRepository;

    @Override
    public void include(AnticipationDTO anticipationDTO) throws ExceededAntecipationClassException {

        //Regra de número de aulas
        if (anticipationDTO.getNumberClasses() > 6)
            throw new ExceededAntecipationClassException("Número de aulas excedido");

        Lecturer lecturer = lecturerRepository.findLecturerBy(anticipationDTO.getLecturer().getCode());

        anticipationRepository.save(
                Anticipation
                        .builder()
                        .reason(anticipationDTO.getReason())
                        .modalitie(
                                anticipationDTO.isInPerson() ?
                                        Modalities.PRESENCIAL :
                                        Modalities.NÃO_PRESENCIAL)
                        .numberClasses(anticipationDTO.getNumberClasses())
                        .lecturer(lecturer)
                        .previousDate(anticipationDTO.getPreviousDate())
                        .date(anticipationDTO.getDate())
                        .build()
        );

    }
}
