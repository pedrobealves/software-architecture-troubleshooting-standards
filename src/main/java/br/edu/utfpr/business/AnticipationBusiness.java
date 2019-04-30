package br.edu.utfpr.business;

import br.edu.utfpr.dto.AnticipationDTO;
import br.edu.utfpr.exception.ExceededAntecipationClassException;
import lombok.Builder;
import lombok.Data;

public class AnticipationBusiness {

    public void include(AnticipationDTO anticipation) throws ExceededAntecipationClassException{

        //Regra de número de aulas
        if(anticipation.getNumber_class() > 6)
            throw new ExceededAntecipationClassException("Número de aulas excedido");

    }
}
