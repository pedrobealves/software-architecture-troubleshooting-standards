package br.edu.utfpr.business;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Anticipation {
    String reason;
    boolean presential;

}
