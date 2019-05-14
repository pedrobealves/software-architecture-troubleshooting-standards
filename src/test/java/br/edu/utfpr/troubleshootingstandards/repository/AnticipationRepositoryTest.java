package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.model.Anticipation;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnticipationRepositoryTest {

    @Autowired
    private AnticipationRepository anticipationRepository;

    @Test
    public void createShouldPersistData(){
        Anticipation anticipation = Anticipation.builder().reason("Gripe").build();
        this.anticipationRepository.save(anticipation);
        assertThat(anticipation.getReason());
    }

}