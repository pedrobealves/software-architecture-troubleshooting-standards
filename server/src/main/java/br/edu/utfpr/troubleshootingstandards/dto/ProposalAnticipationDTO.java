package br.edu.utfpr.troubleshootingstandards.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProposalAnticipationDTO {
    private Long id;
    private AnticipationDTO anticipation;
    private LessonDTO lesson;
}
