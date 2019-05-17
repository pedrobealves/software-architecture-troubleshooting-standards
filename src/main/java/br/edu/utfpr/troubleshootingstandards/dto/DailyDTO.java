package br.edu.utfpr.troubleshootingstandards.dto;

import br.edu.utfpr.troubleshootingstandards.model.AttendanceStudent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyDTO {
    private long id;
    private ApprovalAnticipationDTO approvalAnticipation;
    private LessonDTO lesson;
    private String note;
}
