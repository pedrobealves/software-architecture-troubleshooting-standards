package br.edu.utfpr.troubleshootingstandards.model;

import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "class_course")
public class ClassCourse {
    @Id @GeneratedValue
    private Long id;
    
    @ElementCollection
    private Set<Subject> subjectList;
}
