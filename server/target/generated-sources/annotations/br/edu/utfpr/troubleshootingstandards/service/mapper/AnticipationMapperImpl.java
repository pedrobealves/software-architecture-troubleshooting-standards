package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO.AnticipationDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO.AttendanceStudentDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.ClassCourseDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ClassCourseDTO.ClassCourseDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.LecturerDTO;
import br.edu.utfpr.troubleshootingstandards.dto.LecturerDTO.LecturerDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO;
import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO.LessonDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO.ProposalAnticipationDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.ReasonDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ReasonDTO.ReasonDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.StudentDTO;
import br.edu.utfpr.troubleshootingstandards.dto.StudentDTO.StudentDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.SubjectDTO;
import br.edu.utfpr.troubleshootingstandards.dto.SubjectDTO.SubjectDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.Anticipation;
import br.edu.utfpr.troubleshootingstandards.entity.Anticipation.AnticipationBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.Attendance;
import br.edu.utfpr.troubleshootingstandards.entity.Attendance.AttendanceBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.AttendanceStudent;
import br.edu.utfpr.troubleshootingstandards.entity.ClassCourse;
import br.edu.utfpr.troubleshootingstandards.entity.ClassCourse.ClassCourseBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.Lecturer;
import br.edu.utfpr.troubleshootingstandards.entity.Lecturer.LecturerBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.Lesson;
import br.edu.utfpr.troubleshootingstandards.entity.Lesson.LessonBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.Modalitie;
import br.edu.utfpr.troubleshootingstandards.entity.ProposalAnticipation;
import br.edu.utfpr.troubleshootingstandards.entity.ProposalAnticipation.ProposalAnticipationBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.Reason;
import br.edu.utfpr.troubleshootingstandards.entity.Reason.ReasonBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.ReasonBy;
import br.edu.utfpr.troubleshootingstandards.entity.Student;
import br.edu.utfpr.troubleshootingstandards.entity.Student.StudentBuilder;
import br.edu.utfpr.troubleshootingstandards.entity.Subject;
import br.edu.utfpr.troubleshootingstandards.entity.Subject.SubjectBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_212 (Oracle Corporation)"
)
@Component
public class AnticipationMapperImpl implements AnticipationMapper {

    @Override
    public ProposalAnticipationDTO toProposalAnticipationDTO(ProposalAnticipation proposalAnticipation) {
        if ( proposalAnticipation == null ) {
            return null;
        }

        ProposalAnticipationDTOBuilder proposalAnticipationDTO = ProposalAnticipationDTO.builder();

        if ( proposalAnticipation.getId() != null ) {
            proposalAnticipationDTO.id( proposalAnticipation.getId() );
        }
        proposalAnticipationDTO.anticipation( anticipationToAnticipationDTO( proposalAnticipation.getAnticipation() ) );
        proposalAnticipationDTO.lesson( lessonToLessonDTO( proposalAnticipation.getLesson() ) );

        return proposalAnticipationDTO.build();
    }

    @Override
    public ProposalAnticipation toProposalAnticipation(ProposalAnticipationDTO proposalAnticipationDTO) {
        if ( proposalAnticipationDTO == null ) {
            return null;
        }

        ProposalAnticipationBuilder proposalAnticipation = ProposalAnticipation.builder();

        proposalAnticipation.id( proposalAnticipationDTO.getId() );
        proposalAnticipation.anticipation( toAticipation( proposalAnticipationDTO.getAnticipation() ) );
        proposalAnticipation.lesson( lessonDTOToLesson( proposalAnticipationDTO.getLesson() ) );

        return proposalAnticipation.build();
    }

    @Override
    public List<ProposalAnticipationDTO> toProposalAnticipationDTO(List<ProposalAnticipation> proposalAnticipation) {
        if ( proposalAnticipation == null ) {
            return null;
        }

        List<ProposalAnticipationDTO> list = new ArrayList<ProposalAnticipationDTO>( proposalAnticipation.size() );
        for ( ProposalAnticipation proposalAnticipation1 : proposalAnticipation ) {
            list.add( toProposalAnticipationDTO( proposalAnticipation1 ) );
        }

        return list;
    }

    @Override
    public Anticipation toAticipation(AnticipationDTO anticipationDTO) {
        if ( anticipationDTO == null ) {
            return null;
        }

        AnticipationBuilder anticipation = Anticipation.builder();

        if ( anticipationDTO.getModalitie() != null ) {
            anticipation.modalitie( Enum.valueOf( Modalitie.class, anticipationDTO.getModalitie() ) );
        }
        anticipation.reason( reasonDTOToReason( anticipationDTO.getReason() ) );
        anticipation.numberClasses( anticipationDTO.getNumberClasses() );
        anticipation.nextDate( anticipationDTO.getNextDate() );

        return anticipation.build();
    }

    protected ReasonDTO reasonToReasonDTO(Reason reason) {
        if ( reason == null ) {
            return null;
        }

        ReasonDTOBuilder reasonDTO = ReasonDTO.builder();

        if ( reason.getReasonBy() != null ) {
            reasonDTO.reasonBy( reason.getReasonBy().name() );
        }
        reasonDTO.description( reason.getDescription() );

        return reasonDTO.build();
    }

    protected AnticipationDTO anticipationToAnticipationDTO(Anticipation anticipation) {
        if ( anticipation == null ) {
            return null;
        }

        AnticipationDTOBuilder anticipationDTO = AnticipationDTO.builder();

        anticipationDTO.reason( reasonToReasonDTO( anticipation.getReason() ) );
        if ( anticipation.getModalitie() != null ) {
            anticipationDTO.modalitie( anticipation.getModalitie().name() );
        }
        anticipationDTO.numberClasses( anticipation.getNumberClasses() );
        anticipationDTO.nextDate( anticipation.getNextDate() );

        return anticipationDTO.build();
    }

    protected SubjectDTO subjectToSubjectDTO(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTOBuilder subjectDTO = SubjectDTO.builder();

        subjectDTO.name( subject.getName() );

        return subjectDTO.build();
    }

    protected LecturerDTO lecturerToLecturerDTO(Lecturer lecturer) {
        if ( lecturer == null ) {
            return null;
        }

        LecturerDTOBuilder lecturerDTO = LecturerDTO.builder();

        lecturerDTO.name( lecturer.getName() );

        return lecturerDTO.build();
    }

    protected StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.name( student.getName() );

        return studentDTO.build();
    }

    protected Set<StudentDTO> studentSetToStudentDTOSet(Set<Student> set) {
        if ( set == null ) {
            return null;
        }

        Set<StudentDTO> set1 = new HashSet<StudentDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Student student : set ) {
            set1.add( studentToStudentDTO( student ) );
        }

        return set1;
    }

    protected ClassCourseDTO classCourseToClassCourseDTO(ClassCourse classCourse) {
        if ( classCourse == null ) {
            return null;
        }

        ClassCourseDTOBuilder classCourseDTO = ClassCourseDTO.builder();

        classCourseDTO.subject( subjectToSubjectDTO( classCourse.getSubject() ) );
        classCourseDTO.lecturer( lecturerToLecturerDTO( classCourse.getLecturer() ) );
        classCourseDTO.students( studentSetToStudentDTOSet( classCourse.getStudents() ) );

        return classCourseDTO.build();
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

    protected AttendanceStudentDTO attendanceStudentToAttendanceStudentDTO(AttendanceStudent attendanceStudent) {
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

    protected LessonDTO lessonToLessonDTO(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTOBuilder lessonDTO = LessonDTO.builder();

        lessonDTO.id( lesson.getId() );
        lessonDTO.classCourse( classCourseToClassCourseDTO( lesson.getClassCourse() ) );
        Set<String> set = lesson.getType();
        if ( set != null ) {
            lessonDTO.type( new HashSet<String>( set ) );
        }
        lessonDTO.attendanceStudent( attendanceStudentToAttendanceStudentDTO( lesson.getAttendanceStudent() ) );
        lessonDTO.content( lesson.getContent() );
        lessonDTO.numberClasses( lesson.getNumberClasses() );
        lessonDTO.date( lesson.getDate() );

        return lessonDTO.build();
    }

    protected Subject subjectDTOToSubject(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        SubjectBuilder subject = Subject.builder();

        subject.name( subjectDTO.getName() );

        return subject.build();
    }

    protected Lecturer lecturerDTOToLecturer(LecturerDTO lecturerDTO) {
        if ( lecturerDTO == null ) {
            return null;
        }

        LecturerBuilder lecturer = Lecturer.builder();

        lecturer.name( lecturerDTO.getName() );

        return lecturer.build();
    }

    protected Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        StudentBuilder student = Student.builder();

        student.name( studentDTO.getName() );

        return student.build();
    }

    protected Set<Student> studentDTOSetToStudentSet(Set<StudentDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Student> set1 = new HashSet<Student>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StudentDTO studentDTO : set ) {
            set1.add( studentDTOToStudent( studentDTO ) );
        }

        return set1;
    }

    protected ClassCourse classCourseDTOToClassCourse(ClassCourseDTO classCourseDTO) {
        if ( classCourseDTO == null ) {
            return null;
        }

        ClassCourseBuilder classCourse = ClassCourse.builder();

        classCourse.subject( subjectDTOToSubject( classCourseDTO.getSubject() ) );
        classCourse.lecturer( lecturerDTOToLecturer( classCourseDTO.getLecturer() ) );
        classCourse.students( studentDTOSetToStudentSet( classCourseDTO.getStudents() ) );

        return classCourse.build();
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

    protected AttendanceStudent attendanceStudentDTOToAttendanceStudent(AttendanceStudentDTO attendanceStudentDTO) {
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

    protected Lesson lessonDTOToLesson(LessonDTO lessonDTO) {
        if ( lessonDTO == null ) {
            return null;
        }

        LessonBuilder lesson = Lesson.builder();

        lesson.id( lessonDTO.getId() );
        lesson.classCourse( classCourseDTOToClassCourse( lessonDTO.getClassCourse() ) );
        Set<String> set = lessonDTO.getType();
        if ( set != null ) {
            lesson.type( new HashSet<String>( set ) );
        }
        lesson.attendanceStudent( attendanceStudentDTOToAttendanceStudent( lessonDTO.getAttendanceStudent() ) );
        lesson.content( lessonDTO.getContent() );
        lesson.numberClasses( lessonDTO.getNumberClasses() );
        lesson.date( lessonDTO.getDate() );

        return lesson.build();
    }

    protected Reason reasonDTOToReason(ReasonDTO reasonDTO) {
        if ( reasonDTO == null ) {
            return null;
        }

        ReasonBuilder reason = Reason.builder();

        if ( reasonDTO.getReasonBy() != null ) {
            reason.reasonBy( Enum.valueOf( ReasonBy.class, reasonDTO.getReasonBy() ) );
        }
        reason.description( reasonDTO.getDescription() );

        return reason.build();
    }
}
