package br.edu.utfpr.troubleshootingstandards.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "class_course")
public class ClassCourse implements Serializable {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Lecturer lecturer;

    @OneToMany
    private Set<Student> students;

}
