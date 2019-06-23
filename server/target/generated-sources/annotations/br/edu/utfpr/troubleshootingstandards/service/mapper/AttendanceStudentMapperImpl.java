package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.AttendanceDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO.AttendanceStudentDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.StudentDTO;
import br.edu.utfpr.troubleshootingstandards.dto.StudentDTO.StudentDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.Attendance;
import br.edu.utfpr.troubleshootingstandards.entity.Attendance.AttendanceBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.AttendanceStudent;
import br.edu.utfpr.troubleshootingstandards.entity.Student;
import br.edu.utfpr.troubleshootingstandards.entity.Student.StudentBuilder;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_212 (Oracle Corporation)"
)
@Component
public class AttendanceStudentMapperImpl implements AttendanceStudentMapper {

    @Override
    public AttendanceStudent toAttendanceStudent(AttendanceStudentDTO attendanceStudentDTO) {
        if ( attendanceStudentDTO == null ) {
            return null;
        }

        AttendanceStudent attendanceStudent = new AttendanceStudent();

        attendanceStudent.setId( attendanceStudentDTO.getId() );
        attendanceStudent.setAttendance( attendanceDTOSetToAttendanceSet( attendanceStudentDTO.getAttendance() ) );
        attendanceStudent.setNote( attendanceStudentDTO.getNote() );
        attendanceStudent.setCreatedAt( attendanceStudentDTO.getCreatedAt() );

        return attendanceStudent;
    }

    @Override
    public AttendanceStudentDTO toAttendanceStudentDTO(AttendanceStudent attendanceStudent) {
        if ( attendanceStudent == null ) {
            return null;
        }

        AttendanceStudentDTOBuilder attendanceStudentDTO = AttendanceStudentDTO.builder();

        if ( attendanceStudent.getId() != null ) {
            attendanceStudentDTO.id( attendanceStudent.getId() );
        }
        attendanceStudentDTO.attendance( attendanceSetToAttendanceDTOSet( attendanceStudent.getAttendance() ) );
        attendanceStudentDTO.note( attendanceStudent.getNote() );
        attendanceStudentDTO.createdAt( attendanceStudent.getCreatedAt() );

        return attendanceStudentDTO.build();
    }

    protected Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        StudentBuilder student = Student.builder();

        student.name( studentDTO.getName() );

        return student.build();
    }

    protected Attendance attendanceDTOToAttendance(AttendanceDTO attendanceDTO) {
        if ( attendanceDTO == null ) {
            return null;
        }

        AttendanceBuilder attendance = Attendance.builder();

        attendance.id( attendanceDTO.getId() );
        attendance.student( studentDTOToStudent( attendanceDTO.getStudent() ) );
        attendance.presence( attendanceDTO.isPresence() );

        return attendance.build();
    }

    protected Set<Attendance> attendanceDTOSetToAttendanceSet(Set<AttendanceDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Attendance> set1 = new HashSet<Attendance>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AttendanceDTO attendanceDTO : set ) {
            set1.add( attendanceDTOToAttendance( attendanceDTO ) );
        }

        return set1;
    }

    protected StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.name( student.getName() );

        return studentDTO.build();
    }

    protected AttendanceDTO attendanceToAttendanceDTO(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }

        AttendanceDTO attendanceDTO = new AttendanceDTO();

        if ( attendance.getId() != null ) {
            attendanceDTO.setId( attendance.getId() );
        }
        attendanceDTO.setStudent( studentToStudentDTO( attendance.getStudent() ) );
        attendanceDTO.setPresence( attendance.isPresence() );

        return attendanceDTO;
    }

    protected Set<AttendanceDTO> attendanceSetToAttendanceDTOSet(Set<Attendance> set) {
        if ( set == null ) {
            return null;
        }

        Set<AttendanceDTO> set1 = new HashSet<AttendanceDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Attendance attendance : set ) {
            set1.add( attendanceToAttendanceDTO( attendance ) );
        }

        return set1;
    }
}
