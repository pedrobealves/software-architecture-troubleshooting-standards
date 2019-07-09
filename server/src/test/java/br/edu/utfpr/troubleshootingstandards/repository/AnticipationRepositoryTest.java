package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Sql(value = "/clean-database.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class AnticipationRepositoryTest {

    @Autowired
    private ProposalAnticipationRepository anticipationRepository;

    private Anticipation anticipation;

    @Test
    public void shouldGetDataAnticipation() {
        Optional<ProposalAnticipation> optional = anticipationRepository.findById(1L);

        assertThat(optional.isPresent()).isTrue();

        ProposalAnticipation anticipation = optional.get();
        assertThat(anticipation.getId()).isEqualTo(1);
    }

    @Test
    public void shouldGetDataLesson() {
        Optional<ProposalAnticipation> optional = anticipationRepository.findById(1L);

        assertThat(optional.isPresent()).isTrue();

        Lesson lesson = optional.get().getLesson();
        assertThat(lesson.getId()).isEqualTo(75);
        assertThat(lesson.getContent()).isEqualTo("Lista Encadeada");
    }

    @Test
    public void shouldGetDataLecturer() {
        Optional<ProposalAnticipation> optional = anticipationRepository.findById(1L);

        assertThat(optional.isPresent()).isTrue();

        Lecturer lecturer = optional.get().getLesson().getClassCourse().getLecturer();
        assertThat(lecturer.getId()).isEqualTo(123456);
        assertThat(lecturer.getName()).isEqualTo("Joe");
    }

    @Test
    public void shouldGetNotDataLecturer() {
        Optional<ProposalAnticipation> optional = anticipationRepository.findById(1L);

        assertThat(optional.isPresent()).isTrue();

        Lecturer lecturer = optional.get().getLesson().getClassCourse().getLecturer();
        assertThat(lecturer.getId()).isNotEqualTo(54547);
        assertThat(lecturer.getName()).isNotEqualTo("Willy");
    }

}