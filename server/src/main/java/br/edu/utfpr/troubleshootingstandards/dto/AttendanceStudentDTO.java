package br.edu.utfpr.troubleshootingstandards.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceStudentDTO {
    private long id;
    private Set<AttendanceDTO> attendance;
    private String note;
    private Date createdAt;
}
