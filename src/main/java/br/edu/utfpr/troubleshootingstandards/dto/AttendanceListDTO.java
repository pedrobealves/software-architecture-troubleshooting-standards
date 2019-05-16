package br.edu.utfpr.troubleshootingstandards.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceListDTO {
    private Set<StudentPresenceDTO> studentsList;
}