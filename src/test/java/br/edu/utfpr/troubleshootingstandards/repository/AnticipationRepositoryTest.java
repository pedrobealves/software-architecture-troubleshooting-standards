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

    @Autowired
    private ProposalAnticipationRepository anticipationRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    private Anticipation anticipation;

    @Test
    public void shouldGetDataLecturer() {
        Optional<Lecturer> optional = lecturerRepository.findById(123456L);

        assertThat(optional.isPresent()).isTrue();

        Lecturer lecturer = optional.get();
        assertThat(lecturer.getId()).isEqualTo(123456);
        assertThat(lecturer.getName()).isEqualTo("Joe");
    }

}