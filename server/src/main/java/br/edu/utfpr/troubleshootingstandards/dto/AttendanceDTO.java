package br.edu.utfpr.troubleshootingstandards.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceDTO {
    private Long id;
    private StudentDTO student;
    private boolean presence;
}