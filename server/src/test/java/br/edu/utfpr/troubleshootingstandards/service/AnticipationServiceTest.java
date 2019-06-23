package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.*;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.entity.*;
import br.edu.utfpr.troubleshootingstandards.repository.ProposalAnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.service.mapper.AnticipationMapper;
import br.edu.utfpr.troubleshootingstandards.service.mapper.LessonMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class AnticipationServiceTest {

    private static final String REASON = "Gripe";
    private static final Date NEXT_DATE = new Date(2019, 5, 14);
    private static final Date DATE = new Date(2019, 5, 28);
    private static final int NUMBER_CLASSES = 2;
    private static final String IN_PERSON = Modalitie.PRESENCIAL.name();
    public static final long CODE = 123456;
    public static final String CONTENT = "Estruturas";

    private AnticipationServiceImpl ast;

    @MockBean
    private ProposalAnticipationRepository anticipationRepository;

    private AnticipationMapper anticipationMapper = Mappers.getMapper(AnticipationMapper.class);
    private LessonMapper lessonMapper = Mappers.getMapper(LessonMapper.class);

    private ProposalAnticipationDTO proposalAnticipationDTO;
    private ProposalAnticipation proposalAnticipation;

    private AnticipationDTO anticipationDTO;
    private Anticipation anticipation;

    private LessonDTO lessonDTO;
    private Lesson lesson;

    @Before
    public void setUp() throws Exception {
        ast = new AnticipationServiceImpl(anticipationRepository, anticipationMapper);

        anticipationDTO = AnticipationDTO
                .builder()
                .id(0)
                .reason(ReasonDTO
                        .builder()
                        .reasonBy(ReasonBy.PREVISTO.name())
                        .description(REASON)
                        .build())
                .nextDate(NEXT_DATE)
                .numberClasses(NUMBER_CLASSES)
                .modalitie(IN_PERSON)
                .build();

        lessonDTO = LessonDTO
                .builder()
                .id(CODE)
                .content(CONTENT)
                .date(DATE)
                .build();

        proposalAnticipationDTO = ProposalAnticipationDTO
                .builder()
                .anticipation(anticipationDTO)
                .lesson(lessonDTO)
                .build();

        anticipation = anticipationMapper.toAticipation(proposalAnticipationDTO.getAnticipation());
        lesson = lessonMapper.toLesson(proposalAnticipationDTO.getLesson());

        proposalAnticipation = ProposalAnticipation
                .builder()
                .id(0L)
                .anticipation(anticipation)
                .lesson(lesson)
                .build();
    }

    @Test
    public void shouldInclude() throws Exception {
        ast.include(proposalAnticipationDTO);

        verify(anticipationRepository).save(proposalAnticipation);
    }

    @Test(expected = ExceededAntecipationClassException.class)
    public void shouldNotIncludeNumberLessons() throws Exception {

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

}