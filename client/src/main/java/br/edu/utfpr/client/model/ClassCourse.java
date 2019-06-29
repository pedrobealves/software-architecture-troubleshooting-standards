package br.edu.utfpr.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassCourse {
    
    private long code;
    private Subject subject;
    private Lecturer lecturer;
    private Set<Student> students;
}
