package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.entity.Lecturer;
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
public class LecturerRepositoryTest {

    @Autowired
    LecturerRepository lecturerRepository;

    @Test
    public void shouldGetData() {
        Optional<Lecturer> optional = lecturerRepository.findById((long)123456);

        assertThat(optional.isPresent()).isTrue();

        Lecturer lecturer = optional.get();
        assertThat(lecturer.getId()).isEqualTo(123456);
        assertThat(lecturer.getName()).isEqualTo("Joe");
    }

    @Test
    public void shouldNotGetData() {
        Optional<Lecturer> optional = lecturerRepository.findById((long)123);

        assertThat(optional.isPresent()).isFalse();
    }
}