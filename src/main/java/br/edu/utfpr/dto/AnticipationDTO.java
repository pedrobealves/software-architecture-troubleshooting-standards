package br.edu.utfpr.dto;


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
    private String reason;
    private boolean inPerson;
    private LecturerDTO lecturer;
    private int numberClasses;
    private Date previousDate;
    private Date date;
}
