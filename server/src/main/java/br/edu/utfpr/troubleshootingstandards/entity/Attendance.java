package br.edu.utfpr.troubleshootingstandards.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Attendance implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Student student;

    private boolean presence;

}