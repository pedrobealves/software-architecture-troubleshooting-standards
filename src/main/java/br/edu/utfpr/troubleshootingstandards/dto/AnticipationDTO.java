package br.edu.utfpr.troubleshootingstandards.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnticipationDTO {
    private ReasonDTO reason;
    private boolean inPerson;
    private LecturerDTO lecturer;
    private int numberClasses;
    private Date previousDate;
    private Date date;
}
