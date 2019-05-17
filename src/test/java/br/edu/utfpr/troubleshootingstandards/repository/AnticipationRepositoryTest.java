package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clean-database.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class AnticipationRepositoryTest {

    private static final String REASON = "Convocações  de  trabalho  na  UTFPR";
    private static final Date DATE = new Date(2019, 5, 14);
    private static final Date PREVIOUS_DATE = new Date(2019, 5, 28);
    private static final int NUMBER_CLASSES = 2;
    private static final boolean IN_PERSON = true;
    public static final long CODE = 123456;
    public static final String NAME = "Joe";

    @Autowired
    private ProposalAnticipationRepository anticipationRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    private Anticipation anticipation;

    @Test
    public void shouldGetDataLecturer() {
        Optional<Lecturer> optional = lecturerRepository.findById( (long) 123456);

        assertThat(optional.isPresent()).isTrue();

        Lecturer lecturer = optional.get();
        assertThat(lecturer.getId()).isEqualTo(123456);
        assertThat(lecturer.getName()).isEqualTo("Joe");
    }

}