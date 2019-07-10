package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO;
import br.edu.utfpr.troubleshootingstandards.exception.EntityNotFoundException;
import br.edu.utfpr.troubleshootingstandards.model.AttendanceStudent;
import br.edu.utfpr.troubleshootingstandards.repository.AttendanceStudentRepository;
import br.edu.utfpr.troubleshootingstandards.service.mapper.AttendanceStudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class AttendanceStudentServiceImpl implements AttendanceStudentService {

    @Autowired
    private AttendanceStudentMapper attendanceStudentMapper;

    @Autowired
    private AttendanceStudentRepository attendanceStudentRepository;

    @Override
    public Optional<AttendanceStudentDTO> getById(Long id) throws EntityNotFoundException {
        return Optional.ofNullable(attendanceStudentRepository
                .findById(id)
                .map(a -> attendanceStudentMapper.toAttendanceStudentDTO(a))
                .orElseThrow(() -> new EntityNotFoundException(AttendanceStudent.class, "id", id.toString())));    }

    @Override
    public List<AttendanceStudentDTO> getAll() {
        return attendanceStudentMapper.toAttendanceStudentDTO(attendanceStudentRepository.findAll());
    }
}
