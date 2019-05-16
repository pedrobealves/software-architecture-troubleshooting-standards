package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.LecturerDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ReasonDTO;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.model.*;
import br.edu.utfpr.troubleshootingstandards.repository.AnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.repository.LecturerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AnticipationServiceTest {

    private static final String REASON = "Gripe";
    private static final Date DATE = new Date(2019, 5, 14);
    private static final Date PREVIOUS_DATE = new Date(2019, 5, 28);
    private static final int NUMBER_CLASSES = 2;
    private static final boolean IN_PERSON = true;
    public static final String CODE = "123456";
    public static final String NAME = "Joe";

    @MockBean
    private AnticipationRepository anticipationRepository;

    @MockBean
    private LecturerRepository lecturerRepository;

    private AnticipationService ast;

    private AnticipationDTO anticipationDTO;
    private LecturerDTO lecturerDTO;

    private Anticipation anticipation;
    private Lecturer lecturer;

    @Before
    public void setUp() throws Exception{
        ast = new AnticipationServiceImpl(lecturerRepository, anticipationRepository);

        lecturerDTO = LecturerDTO
                .builder()
                .code(CODE)
                .name(NAME)
                .build();

        lecturer = Lecturer
                .builder()
                .code(lecturerDTO.getCode())
                .name(lecturerDTO.getName())
                .build();

        anticipationDTO = AnticipationDTO
                .builder()
                .reason(ReasonDTO
                        .builder()
                        .reasonBy(ReasonBy.PREVISTO.name())
                        .description(REASON)
                        .build())
                .date(DATE)
                .previousDate(PREVIOUS_DATE)
                .numberClasses(NUMBER_CLASSES)
                .inPerson(IN_PERSON)
                .lecturer(lecturerDTO)
                .build();

        anticipation = Anticipation
                .builder()
                .reason(Reason
                        .builder()
                        .reasonBy(ReasonBy.PREVISTO)
                        .description(REASON)
                        .build()
                )
                .date(anticipationDTO.getDate())
                .previousDate(anticipationDTO.getPreviousDate())
                .numberClasses(anticipationDTO.getNumberClasses())
                .modalitie(anticipationDTO.isInPerson() ? Modalities.PRESENCIAL : Modalities.NÃO_PRESENCIAL)
                .lecturer(lecturer)
                .build();

        when(lecturerRepository.findByCode(CODE)).thenReturn(Optional.of(lecturer));

    }

    @Test
    public void shouldInclude() throws Exception {
        ast.include(anticipationDTO);

        verify(anticipationRepository).save(anticipation);
    }

    @Test(expected = ExceededAntecipationClassException.class)
    public void shouldNotIncludeNumberLessons() throws Exception{

        anticipationDTO.setNumberClasses(10);

        anticipation.setNumberClasses(anticipationDTO.getNumberClasses());

        ast.include(anticipationDTO);

        verify(anticipationRepository).save(anticipation);
    }

    @Test(expected = DateAnticipationException.class)
    public void shouldNotIncludeAfterDate() throws Exception {
        anticipationDTO.setDate(new Date(2019, 6, 5));

        anticipation.setDate(anticipationDTO.getDate());

        ast.include(anticipationDTO);

        verify(anticipationRepository).save(anticipation);
    }

    @Test
    public void shouldFindLecturerAnticipation() {

    }
}