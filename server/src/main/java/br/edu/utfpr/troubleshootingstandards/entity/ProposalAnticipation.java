package br.edu.utfpr.troubleshootingstandards.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProposalAnticipation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Anticipation anticipation;

    @OneToOne
    private Lesson lesson;
}
