package br.edu.utfpr.service;

import br.edu.utfpr.dto.AnticipationDTO;
import br.edu.utfpr.exception.ExceededAntecipationClassException;
import br.edu.utfpr.model.Anticipation;
import br.edu.utfpr.model.Lecturer;
import br.edu.utfpr.model.Modalities;
import br.edu.utfpr.repository.AnticipationRepository;
import br.edu.utfpr.repository.LecturerRepository;
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
