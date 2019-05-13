package br.edu.utfpr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyDTO {
    private AnticipationDTO anticipation;
    private String content;
    private String note;
}
