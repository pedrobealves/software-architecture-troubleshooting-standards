package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.model.Anticipation;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnticipationRepositoryTest {
    @Autowired
    private AnticipationRepository anticipationRepository;
    @Test
    public void createShouldPersistData(){
        Anticipation anticipation = Anticipation.builder().reason("Gripe").build();
        this.anticipationRepository.save(anticipation);
        Assertions.assertThat(anticipation.getReason());
    }
}