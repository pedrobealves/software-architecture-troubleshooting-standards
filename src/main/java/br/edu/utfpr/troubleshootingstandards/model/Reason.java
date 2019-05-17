package br.edu.utfpr.troubleshootingstandards.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Reason {

    @Enumerated(EnumType.STRING)
    private ReasonBy reasonBy;

    @Column(name = "description_reason")
    private String description;
}
