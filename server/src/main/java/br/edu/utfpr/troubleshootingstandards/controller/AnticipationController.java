package br.edu.utfpr.troubleshootingstandards.controller;

import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.entity.Modalitie;
import br.edu.utfpr.troubleshootingstandards.entity.Reason;
import br.edu.utfpr.troubleshootingstandards.entity.ReasonBy;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.service.AnticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class AnticipationController {

    @Autowired
    private AnticipationService anticipationService;

    @GetMapping("/anticipation")
    public ResponseEntity<List<ProposalAnticipationDTO>> getAll() {
        return ResponseEntity.ok(anticipationService.getAll());
    }

    @PostMapping("/anticipation")
    public ResponseEntity<ProposalAnticipationDTO> save(@RequestBody ProposalAnticipationDTO proposalAnticipationDTO) throws ExceededAntecipationClassException, DateAnticipationException {
            anticipationService.include(proposalAnticipationDTO);
            return ResponseEntity.status(201).body(proposalAnticipationDTO);
    }

    @GetMapping ("/anticipation/{id}")
    public ResponseEntity<ProposalAnticipationDTO> getById(@PathVariable Long id) {
        Optional<ProposalAnticipationDTO> clienteEncontrado = anticipationService.getById(id);
        return ResponseEntity.of(clienteEncontrado);
    }

    @DeleteMapping ("/anticipation/{id}")
    public ResponseEntity excluir (@PathVariable long id) {
            anticipationService.delete(id);
            return ResponseEntity.noContent().build();
    }

    @PutMapping("/anticipation/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody ProposalAnticipationDTO proposalAnticipationDTO, @PathVariable long id) throws ExceededAntecipationClassException, DateAnticipationException {

        Optional<ProposalAnticipationDTO> proposalAnticipation = anticipationService.getById(id);

        if (!proposalAnticipation.isPresent())
            return ResponseEntity.notFound().build();

        proposalAnticipationDTO.setId(id);

        anticipationService.include(proposalAnticipationDTO);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/anticipation/modalities")
    public ResponseEntity<Modalitie[]> getModalities() {
        return ResponseEntity.of(Optional.of(Modalitie.values()));
    }

    @GetMapping("/anticipation/reasons")
    public ResponseEntity<ReasonBy[]> getReasons() {
        return ResponseEntity.of(Optional.of(ReasonBy.values()));
    }

    @ExceptionHandler(ExceededAntecipationClassException.class)
    public ResponseEntity handleException(ExceededAntecipationClassException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(e.getMessage());
    }

    @ExceptionHandler(DateAnticipationException.class)
    public ResponseEntity handleException(DateAnticipationException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(e.getMessage());
    }

}
