package br.edu.utfpr.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AnticipationDTO {
    private String reason;
    private boolean presential;
    private LecturerDTO lecturer;
    private int number_class;
    private LocalDateTime previous_date;
    private LocalDateTime date;
    private String daily;
}
