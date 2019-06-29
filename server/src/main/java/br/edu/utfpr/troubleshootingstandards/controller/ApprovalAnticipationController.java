package br.edu.utfpr.troubleshootingstandards.controller;

import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.ConsentsAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.DateAnticipationException;
import br.edu.utfpr.troubleshootingstandards.exception.ExceededAntecipationClassException;
import br.edu.utfpr.troubleshootingstandards.service.ApprovalAnticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/anticipation")
@RestController
public class ApprovalAnticipationController {

    @Autowired
    private ApprovalAnticipationService approvalAnticipationService;

    @PostMapping("/approval")
    public ResponseEntity<ApprovalAnticipationDTO> save(@RequestBody ApprovalAnticipationDTO approvalAnticipationDTO) throws ConsentsAnticipationException {
        approvalAnticipationService.include(approvalAnticipationDTO);
        return ResponseEntity.status(201).body(approvalAnticipationDTO);
    }

    @GetMapping ("/approval/{id}")
    public ResponseEntity<ApprovalAnticipationDTO> getById(@PathVariable Long id) {
        Optional<ApprovalAnticipationDTO> approvalAnticipationDTO = approvalAnticipationService.getById(id);
        return ResponseEntity.of(approvalAnticipationDTO);
    }

    @ExceptionHandler(ConsentsAnticipationException.class)
    public ResponseEntity handleException(ConsentsAnticipationException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(e.getMessage());
    }
}
