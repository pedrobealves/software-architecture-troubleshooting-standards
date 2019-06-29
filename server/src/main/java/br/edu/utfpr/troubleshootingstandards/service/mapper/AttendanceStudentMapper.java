package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO;
import br.edu.utfpr.troubleshootingstandards.entity.AttendanceStudent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface AttendanceStudentMapper {
    AttendanceStudent toAttendanceStudent(AttendanceStudentDTO attendanceStudentDTO);
    AttendanceStudentDTO toAttendanceStudentDTO(AttendanceStudent attendanceStudent);
}
