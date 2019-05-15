package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.model.Anticipation;
import br.edu.utfpr.troubleshootingstandards.model.Lecturer;
import br.edu.utfpr.troubleshootingstandards.model.Modalities;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static br.edu.utfpr.troubleshootingstandards.service.AnticipationServiceTest.CODE;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class AnticipationRepositoryTest {

    private static final String REASON = "Gripe";
    private static final Date DATE = new Date(2019, 5, 14);
    private static final Date PREVIOUS_DATE = new Date(2019, 5, 28);
    private static final int NUMBER_CLASSES = 2;
    private static final boolean IN_PERSON = true;
    public static final String CODE = "123456";
    public static final String NAME = "Joe";

    @Autowired
    private AnticipationRepository anticipationRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    private Lecturer lecturer;
    private Anticipation anticipation;

    @Before
    public void setUp(){
        lecturer = Lecturer
                .builder()
                .code(CODE)
                .name(NAME)
                .build();

        anticipation = Anticipation
                .builder()
                .reason(REASON)
                .date(DATE)
                .previousDate(PREVIOUS_DATE)
                .numberClasses(NUMBER_CLASSES)
                .modalitie(Modalities.PRESENCIAL)
                .lecturer(lecturer)
                .build();

        anticipationRepository.save(anticipation);

    }

    @Test
    public void shouldGetDataLecturer() {
        Optional<Lecturer> optional = lecturerRepository.findByCode("123456");

        assertThat(optional.isPresent()).isTrue();

        Lecturer lecturer = optional.get();
        assertThat(lecturer.getCode()).isEqualTo("123456");
        assertThat(lecturer.getName()).isEqualTo("Joe");
    }

}