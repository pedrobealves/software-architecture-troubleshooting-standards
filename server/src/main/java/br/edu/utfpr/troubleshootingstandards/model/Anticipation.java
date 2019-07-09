package br.edu.utfpr.troubleshootingstandards.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Anticipation implements Serializable {

    @Embedded
    private Reason reason;

    @Enumerated(EnumType.STRING)
    private Modalitie modalitie;

    @Column(name="number_classes")
    @Min(1)
    private int numberClasses;

    @Column(name="next_date")
    @NotNull
    private LocalDate nextDate;

}
