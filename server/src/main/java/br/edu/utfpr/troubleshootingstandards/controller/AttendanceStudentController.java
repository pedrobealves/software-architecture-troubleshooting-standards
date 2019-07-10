package br.edu.utfpr.troubleshootingstandards.controller;

import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO;
import br.edu.utfpr.troubleshootingstandards.exception.EntityNotFoundException;
import br.edu.utfpr.troubleshootingstandards.service.AttendanceStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class AttendanceStudentController {

    @Autowired
    private AttendanceStudentService attendanceStudentService;

    @GetMapping("/attendances")
    public ResponseEntity<List<AttendanceStudentDTO>> getAll() {
        return ResponseEntity.ok(attendanceStudentService.getAll());
    }

    @GetMapping ("/attendances/{id}")
    public ResponseEntity<AttendanceStudentDTO> getById(@PathVariable Long id) throws EntityNotFoundException {
        Optional<AttendanceStudentDTO> attendanceStudent = attendanceStudentService.getById(id);
        return ResponseEntity.of(attendanceStudent);
    }
}
