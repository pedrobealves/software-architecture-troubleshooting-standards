package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.*;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.model.*;
import br.edu.utfpr.troubleshootingstandards.repository.LessonRepository;
import br.edu.utfpr.troubleshootingstandards.repository.ProposalAnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.repository.LecturerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AnticipationServiceTest {

    private static final String REASON = "Gripe";
    private static final Date NEXT_DATE = new Date(2019, 5, 14);
    private static final Date DATE = new Date(2019, 5, 28);
    private static final int NUMBER_CLASSES = 2;
    private static final boolean IN_PERSON = true;
    public static final long CODE = 123456;
    public static final String NAME = "Joe";
    public static final String ESTRUTURAS = "Estruturas";

    @MockBean
    private ProposalAnticipationRepository anticipationRepository;

    @MockBean
    private LessonRepository lessonRepository;

    private AnticipationServiceImpl ast;

    private ProposalAnticipationDTO proposalAnticipationDTO;
    private AnticipationDTO anticipationDTO;
    private LessonDTO lessonDTO;

    private ProposalAnticipation proposalAnticipation;
    private Anticipation anticipation;
    private Lesson lesson;

    @Before
    public void setUp() throws Exception{
        ast = new AnticipationServiceImpl(lessonRepository, anticipationRepository);

        anticipationDTO = AnticipationDTO
                .builder()
                .reason(ReasonDTO
                        .builder()
                        .reasonBy(ReasonBy.PREVISTO.name())
                        .description(REASON)
                        .build())
                .nextDate(NEXT_DATE)
                .numberClasses(NUMBER_CLASSES)
                .inPerson(IN_PERSON)
                .build();

        lessonDTO = LessonDTO
                .builder()
                .id(CODE)
                .content(ESTRUTURAS)
                .date(DATE)
                .build();

        proposalAnticipationDTO = ProposalAnticipationDTO
                .builder()
                .anticipation(anticipationDTO)
                .lesson(lessonDTO)
                .build();

        anticipation = anticipationDTOtoAnticipation(proposalAnticipationDTO.getAnticipation());
        lesson = lessonDTOtoLesson(proposalAnticipationDTO.getLesson());

        proposalAnticipation = ProposalAnticipation
                .builder()
                .anticipation(anticipation)
                .lesson(lesson)
                .build();


        when(lessonRepository.findById(CODE)).thenReturn(Optional.of(lesson));

    }

    @Test
    public void shouldInclude() throws Exception {
        ast.include(proposalAnticipationDTO);

        verify(anticipationRepository).save(proposalAnticipation);
    }

    @Test(expected = ExceededAntecipationClassException.class)
    public void shouldNotIncludeNumberLessons() throws Exception{

        anticipationDTO.setNumberClasses(10);

        anticipation.setNumberClasses(anticipationDTO.getNumberClasses());

        ast.include(proposalAnticipationDTO);

        verify(anticipationRepository).save(proposalAnticipation);
    }

    @Test(expected = DateAnticipationException.class)
    public void shouldNotIncludeAfterDate() throws Exception {
        anticipationDTO.setNextDate(new Date(2019, 6, 5));

        anticipation.setNextDate(anticipationDTO.getNextDate());

        ast.include(proposalAnticipationDTO);

        verify(anticipationRepository).save(proposalAnticipation);
    }


    private Lesson lessonDTOtoLesson(LessonDTO lessonDTO){
        return Lesson
                .builder()
                .id(lessonDTO.getId())
                .content(lessonDTO.getContent())
                .date(lessonDTO.getDate())
                .build();
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