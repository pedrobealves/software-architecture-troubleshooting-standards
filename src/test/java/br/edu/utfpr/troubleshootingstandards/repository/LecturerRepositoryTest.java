package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.model.Lecturer;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class LecturerRepositoryTest {

    @Autowired
    LecturerRepository lecturerRepository;

    @Before
    public void setUp(){
        lecturerRepository.save(
                Lecturer.builder()
                .code("123456")
                .name("Joe")
                .build()
        );
    }

    @Test
    public void shouldGetData() {
        Optional<Lecturer> optional = lecturerRepository.findByCode("123456");

        assertThat(optional.isPresent()).isTrue();

        Lecturer lecturer = optional.get();
        assertThat(lecturer.getCode()).isEqualTo("123456");
        assertThat(lecturer.getName()).isEqualTo("Joe");
    }

    @Test
    public void shouldNotGetData() {
        Optional<Lecturer> optional = lecturerRepository.findByCode("123");

        assertThat(optional.isPresent()).isFalse();
    }
}