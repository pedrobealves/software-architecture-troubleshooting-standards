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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ApprovalAnticipationController {

    @Autowired
    private ApprovalAnticipationService approvalAnticipationService;


    @GetMapping("/approvals")
    // returns list of all approvals
    public ResponseEntity<List<ApprovalAnticipationDTO>> getAll() {
        return ResponseEntity.ok(approvalAnticipationService.getAll());
    }

    @PostMapping("/approvals")
    // creates and saves a new approval
    public ResponseEntity<ApprovalAnticipationDTO> save(@Valid @RequestBody ApprovalAnticipationDTO approvalAnticipationDTO) throws ConsentsAnticipationException {
        approvalAnticipationService.include(approvalAnticipationDTO);
        return ResponseEntity.status(201).body(approvalAnticipationDTO);
    }

    @GetMapping ("/approvals/{id}")
    // get a specific approval by id
    public ResponseEntity<ApprovalAnticipationDTO> getById(@PathVariable Long id) {
        Optional<ApprovalAnticipationDTO> approvalAnticipationDTO = approvalAnticipationService.getById(id);
        return ResponseEntity.of(approvalAnticipationDTO);
    }
}
