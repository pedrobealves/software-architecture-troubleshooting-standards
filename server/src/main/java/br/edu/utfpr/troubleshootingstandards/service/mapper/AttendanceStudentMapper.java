package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO;
import br.edu.utfpr.troubleshootingstandards.model.AttendanceStudent;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AttendanceStudentMapper {
    AttendanceStudent toAttendanceStudent(AttendanceStudentDTO attendanceStudentDTO);
    AttendanceStudentDTO toAttendanceStudentDTO(AttendanceStudent attendanceStudent);
    List<AttendanceStudentDTO> toAttendanceStudentDTO(List<AttendanceStudent> attendanceStudents);
}
