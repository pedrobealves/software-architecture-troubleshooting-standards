package br.edu.utfpr.troubleshootingstandards.model;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ClassCourseDTO;
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
public class ProposalAnticipation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Anticipation anticipation;

    @OneToOne
    private Lesson lesson;

    @OneToOne(cascade = CascadeType.ALL)
    private AttendanceStudent consents;
}
