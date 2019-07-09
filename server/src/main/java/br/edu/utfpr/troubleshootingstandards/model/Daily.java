package br.edu.utfpr.troubleshootingstandards.model;

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
public class Daily implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Lesson lesson;

    private String note;
}
