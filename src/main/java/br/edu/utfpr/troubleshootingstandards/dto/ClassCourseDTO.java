package br.edu.utfpr.troubleshootingstandards.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa um DTO de turma
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassCourseDTO {
    
    private String code;
    private Set<SubjectDTO> subjectList;
    
}
