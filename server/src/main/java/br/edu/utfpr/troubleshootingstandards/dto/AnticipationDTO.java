package br.edu.utfpr.troubleshootingstandards.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnticipationDTO {
    private Long id;
    private ReasonDTO reason;
    private String modalitie;
    private int numberClasses;
    private LocalDate nextDate;
}
