package br.edu.utfpr.service;

import br.edu.utfpr.dto.AnticipationDTO;
import br.edu.utfpr.exception.ExceededAntecipationClassException;
import org.springframework.stereotype.Service;

@Service
public interface AnticipationService {

    void include(AnticipationDTO anticipation) throws ExceededAntecipationClassException;

}
