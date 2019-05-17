package br.edu.utfpr.troubleshootingstandards.dto;

import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassCourseDTO {
    
    private long code;
    private SubjectDTO subject;
    private LecturerDTO lecturer;
    private Set<StudentDTO> students;
}
