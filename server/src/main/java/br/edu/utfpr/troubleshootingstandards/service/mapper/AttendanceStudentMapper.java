package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO;
import br.edu.utfpr.troubleshootingstandards.model.AttendanceStudent;
import org.mapstruct.Mapper;

@Mapper
public interface AttendanceStudentMapper {
    AttendanceStudent toAttendanceStudent(AttendanceStudentDTO attendanceStudentDTO);
    AttendanceStudentDTO toAttendanceStudentDTO(AttendanceStudent attendanceStudent);
}
