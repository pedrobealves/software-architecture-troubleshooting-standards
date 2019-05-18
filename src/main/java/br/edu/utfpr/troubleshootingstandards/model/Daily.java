package br.edu.utfpr.troubleshootingstandards.model;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Daily implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Anticipation anticipation;

    @OneToOne
    private Lesson lesson;

    private String note;
}
