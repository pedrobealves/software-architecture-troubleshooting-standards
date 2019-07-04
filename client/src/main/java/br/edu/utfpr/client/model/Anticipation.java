package br.edu.utfpr.client.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Anticipation {
    private long id;
    private Reason reason;
    private String modalitie;
    private int numberClasses;
    private String nextDate;
}
