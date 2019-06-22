package br.edu.utfpr.troubleshootingstandards.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceDTO {
    private long id;
    private StudentDTO student;
    private boolean presence;
    private AttendanceStudentDTO attendanceStudent;
}