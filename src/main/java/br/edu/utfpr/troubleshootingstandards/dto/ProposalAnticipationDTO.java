package br.edu.utfpr.troubleshootingstandards.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProposalAnticipationDTO {
    private long id;
    private AnticipationDTO anticipation;
    private LessonDTO lesson;
    private AttendanceStudentDTO consents;
}
