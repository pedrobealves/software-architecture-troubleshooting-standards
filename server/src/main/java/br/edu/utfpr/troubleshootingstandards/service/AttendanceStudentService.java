package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO;
import br.edu.utfpr.troubleshootingstandards.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AttendanceStudentService {
    Optional<AttendanceStudentDTO> getById(Long id) throws EntityNotFoundException;
    List<AttendanceStudentDTO> getAll();
}
