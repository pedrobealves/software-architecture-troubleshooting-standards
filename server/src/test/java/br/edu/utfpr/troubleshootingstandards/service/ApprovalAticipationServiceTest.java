package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.*;
import br.edu.utfpr.troubleshootingstandards.entity.*;
import br.edu.utfpr.troubleshootingstandards.repository.ApprovalAnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.repository.LessonRepository;
import br.edu.utfpr.troubleshootingstandards.service.mapper.AnticipationMapper;
import br.edu.utfpr.troubleshootingstandards.service.mapper.ApprovalAnticipationMapper;
import br.edu.utfpr.troubleshootingstandards.service.mapper.LessonMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ApprovalAticipationServiceTest {

    private static final String REASON = "Gripe";
    private static final Date NEXT_DATE = new Date(2019, 5, 14);
    private static final Date DATE = new Date(2019, 5, 28);
    private static final int NUMBER_CLASSES = 2;
    private static final boolean IN_PERSON = true;
    public static final long CODE = 123456;
    public static final String CONTENT = "Estruturas";

    private ApprovalAnticipationServiceImpl as;

    private ApprovalAnticipationMapper approvalAnticipationMapper = Mappers.getMapper(ApprovalAnticipationMapper.class);
    private AnticipationMapper anticipationMapper = Mappers.getMapper(AnticipationMapper.class);
    private LessonMapper lessonMapper = Mappers.getMapper(LessonMapper.class);

    private LessonDTO lessonDTO;
    private Lesson lesson;

    private ApprovalAnticipationDTO approvalAnticipationDTO;
    private ApprovalAnticipation approvalAnticipation;

    private ProposalAnticipationDTO proposalAnticipationDTO;
    private ProposalAnticipation proposalAnticipation;

    private AnticipationDTO anticipationDTO;
    private Anticipation anticipation;

    @MockBean
    private ApprovalAnticipationRepository approvalAnticipationRepository;
    @MockBean
    private LessonRepository lessonRepository;

    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void shouldInclude() throws Exception {

    }

}
