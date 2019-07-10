package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO.AnticipationDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO.ApprovalAnticipationDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceDTO.AttendanceDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO.AttendanceStudentDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.ClassCourseDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ClassCourseDTO.ClassCourseDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.CoordinatorCourseDTO;
import br.edu.utfpr.troubleshootingstandards.dto.CoordinatorCourseDTO.CoordinatorCourseDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.DepartmentDTO;
import br.edu.utfpr.troubleshootingstandards.dto.DepartmentDTO.DepartmentDTOBuilder;
import br.edu.utfpr.troubleshootingstandards.dto.DepartmentLeaderDTO;
import br.edu.utfpr.troubleshootingstandards.dto.DepartmentLeaderDTO.DepartmentLeaderDTOBuilder;
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
import br.edu.utfpr.troubleshootingstandards.model.Anticipation;
import br.edu.utfpr.troubleshootingstandards.model.Anticipation.AnticipationBuilder;
import br.edu.utfpr.troubleshootingstandards.model.ApprovalAnticipation;
import br.edu.utfpr.troubleshootingstandards.model.Attendance;
import br.edu.utfpr.troubleshootingstandards.model.Attendance.AttendanceBuilder;
import br.edu.utfpr.troubleshootingstandards.model.AttendanceStudent;
import br.edu.utfpr.troubleshootingstandards.model.AttendanceStudent.AttendanceStudentBuilder;
import br.edu.utfpr.troubleshootingstandards.model.ClassCourse;
import br.edu.utfpr.troubleshootingstandards.model.ClassCourse.ClassCourseBuilder;
import br.edu.utfpr.troubleshootingstandards.model.CoordinatorCourse;
import br.edu.utfpr.troubleshootingstandards.model.Department;
import br.edu.utfpr.troubleshootingstandards.model.DepartmentLeader;
import br.edu.utfpr.troubleshootingstandards.model.Lecturer;
import br.edu.utfpr.troubleshootingstandards.model.Lecturer.LecturerBuilder;
import br.edu.utfpr.troubleshootingstandards.model.Lesson;
import br.edu.utfpr.troubleshootingstandards.model.Lesson.LessonBuilder;
import br.edu.utfpr.troubleshootingstandards.model.Modalitie;
import br.edu.utfpr.troubleshootingstandards.model.ProposalAnticipation;
import br.edu.utfpr.troubleshootingstandards.model.ProposalAnticipation.ProposalAnticipationBuilder;
import br.edu.utfpr.troubleshootingstandards.model.Reason;
import br.edu.utfpr.troubleshootingstandards.model.Reason.ReasonBuilder;
import br.edu.utfpr.troubleshootingstandards.model.ReasonBy;
import br.edu.utfpr.troubleshootingstandards.model.Student;
import br.edu.utfpr.troubleshootingstandards.model.Student.StudentBuilder;
import br.edu.utfpr.troubleshootingstandards.model.Subject;
import br.edu.utfpr.troubleshootingstandards.model.Subject.SubjectBuilder;
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
public class ApprovalAnticipationMapperImpl implements ApprovalAnticipationMapper {

    @Override
    public ApprovalAnticipation toApprovalAnticipation(ApprovalAnticipationDTO approvalAnticipationDTO) {
        if ( approvalAnticipationDTO == null ) {
            return null;
        }

        ApprovalAnticipation approvalAnticipation = new ApprovalAnticipation();

        approvalAnticipation.setId( approvalAnticipationDTO.getId() );
        approvalAnticipation.setProposalAnticipation( proposalAnticipationDTOToProposalAnticipation( approvalAnticipationDTO.getProposalAnticipation() ) );
        approvalAnticipation.setConsents( attendanceStudentDTOToAttendanceStudent( approvalAnticipationDTO.getConsents() ) );

        return approvalAnticipation;
    }

    @Override
    public ApprovalAnticipationDTO toApprovalAnticipationDTO(ApprovalAnticipation approvalAnticipation) {
        if ( approvalAnticipation == null ) {
            return null;
        }

        ApprovalAnticipationDTOBuilder approvalAnticipationDTO = ApprovalAnticipationDTO.builder();

        approvalAnticipationDTO.id( approvalAnticipation.getId() );
        approvalAnticipationDTO.proposalAnticipation( proposalAnticipationToProposalAnticipationDTO( approvalAnticipation.getProposalAnticipation() ) );
        approvalAnticipationDTO.consents( attendanceStudentToAttendanceStudentDTO( approvalAnticipation.getConsents() ) );
        approvalAnticipationDTO.departmentLeader( departmentLeaderToDepartmentLeaderDTO( approvalAnticipation.getDepartmentLeader() ) );
        approvalAnticipationDTO.coordinatorCourse( coordinatorCourseToCoordinatorCourseDTO( approvalAnticipation.getCoordinatorCourse() ) );
        approvalAnticipationDTO.approved( approvalAnticipation.isApproved() );

        return approvalAnticipationDTO.build();
    }

    @Override
    public List<ApprovalAnticipationDTO> toApprovalAnticipationDTO(List<ApprovalAnticipation> approvalAnticipationDTO) {
        if ( approvalAnticipationDTO == null ) {
            return null;
        }

        List<ApprovalAnticipationDTO> list = new ArrayList<ApprovalAnticipationDTO>( approvalAnticipationDTO.size() );
        for ( ApprovalAnticipation approvalAnticipation : approvalAnticipationDTO ) {
            list.add( toApprovalAnticipationDTO( approvalAnticipation ) );
        }

        return list;
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

    protected Anticipation anticipationDTOToAnticipation(AnticipationDTO anticipationDTO) {
        if ( anticipationDTO == null ) {
            return null;
        }

        AnticipationBuilder anticipation = Anticipation.builder();

        anticipation.reason( reasonDTOToReason( anticipationDTO.getReason() ) );
        if ( anticipationDTO.getModalitie() != null ) {
            anticipation.modalitie( Enum.valueOf( Modalitie.class, anticipationDTO.getModalitie() ) );
        }
        anticipation.numberClasses( anticipationDTO.getNumberClasses() );
        anticipation.nextDate( anticipationDTO.getNextDate() );

        return anticipation.build();
    }

    protected Subject subjectDTOToSubject(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        SubjectBuilder subject = Subject.builder();

        subject.id( subjectDTO.getId() );
        subject.name( subjectDTO.getName() );

        return subject.build();
    }

    protected Lecturer lecturerDTOToLecturer(LecturerDTO lecturerDTO) {
        if ( lecturerDTO == null ) {
            return null;
        }

        LecturerBuilder lecturer = Lecturer.builder();

        lecturer.id( lecturerDTO.getId() );
        lecturer.name( lecturerDTO.getName() );

        return lecturer.build();
    }

    protected Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        StudentBuilder student = Student.builder();

        student.id( studentDTO.getId() );
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

        classCourse.id( classCourseDTO.getId() );
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

        AttendanceStudentBuilder attendanceStudent = AttendanceStudent.builder();

        attendanceStudent.id( attendanceStudentDTO.getId() );
        attendanceStudent.attendance( attendanceDTOSetToAttendanceSet( attendanceStudentDTO.getAttendance() ) );
        attendanceStudent.note( attendanceStudentDTO.getNote() );
        attendanceStudent.createdAt( attendanceStudentDTO.getCreatedAt() );

        return attendanceStudent.build();
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

    protected ProposalAnticipation proposalAnticipationDTOToProposalAnticipation(ProposalAnticipationDTO proposalAnticipationDTO) {
        if ( proposalAnticipationDTO == null ) {
            return null;
        }

        ProposalAnticipationBuilder proposalAnticipation = ProposalAnticipation.builder();

        proposalAnticipation.id( proposalAnticipationDTO.getId() );
        proposalAnticipation.anticipation( anticipationDTOToAnticipation( proposalAnticipationDTO.getAnticipation() ) );
        proposalAnticipation.lesson( lessonDTOToLesson( proposalAnticipationDTO.getLesson() ) );

        return proposalAnticipation.build();
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

        subjectDTO.id( subject.getId() );
        subjectDTO.name( subject.getName() );

        return subjectDTO.build();
    }

    protected LecturerDTO lecturerToLecturerDTO(Lecturer lecturer) {
        if ( lecturer == null ) {
            return null;
        }

        LecturerDTOBuilder lecturerDTO = LecturerDTO.builder();

        lecturerDTO.id( lecturer.getId() );
        lecturerDTO.name( lecturer.getName() );

        return lecturerDTO.build();
    }

    protected StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.name( student.getName() );
        studentDTO.id( student.getId() );

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

        classCourseDTO.id( classCourse.getId() );
        classCourseDTO.subject( subjectToSubjectDTO( classCourse.getSubject() ) );
        classCourseDTO.lecturer( lecturerToLecturerDTO( classCourse.getLecturer() ) );
        classCourseDTO.students( studentSetToStudentDTOSet( classCourse.getStudents() ) );

        return classCourseDTO.build();
    }

    protected AttendanceDTO attendanceToAttendanceDTO(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }

        AttendanceDTOBuilder attendanceDTO = AttendanceDTO.builder();

        attendanceDTO.id( attendance.getId() );
        attendanceDTO.student( studentToStudentDTO( attendance.getStudent() ) );
        attendanceDTO.presence( attendance.isPresence() );

        return attendanceDTO.build();
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

        attendanceStudentDTO.id( attendanceStudent.getId() );
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

    protected ProposalAnticipationDTO proposalAnticipationToProposalAnticipationDTO(ProposalAnticipation proposalAnticipation) {
        if ( proposalAnticipation == null ) {
            return null;
        }

        ProposalAnticipationDTOBuilder proposalAnticipationDTO = ProposalAnticipationDTO.builder();

        proposalAnticipationDTO.id( proposalAnticipation.getId() );
        proposalAnticipationDTO.anticipation( anticipationToAnticipationDTO( proposalAnticipation.getAnticipation() ) );
        proposalAnticipationDTO.lesson( lessonToLessonDTO( proposalAnticipation.getLesson() ) );

        return proposalAnticipationDTO.build();
    }

    protected DepartmentDTO departmentToDepartmentDTO(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDTOBuilder departmentDTO = DepartmentDTO.builder();

        departmentDTO.id( department.getId() );
        departmentDTO.name( department.getName() );

        return departmentDTO.build();
    }

    protected DepartmentLeaderDTO departmentLeaderToDepartmentLeaderDTO(DepartmentLeader departmentLeader) {
        if ( departmentLeader == null ) {
            return null;
        }

        DepartmentLeaderDTOBuilder departmentLeaderDTO = DepartmentLeaderDTO.builder();

        departmentLeaderDTO.id( departmentLeader.getId() );
        departmentLeaderDTO.name( departmentLeader.getName() );
        departmentLeaderDTO.department( departmentToDepartmentDTO( departmentLeader.getDepartment() ) );

        return departmentLeaderDTO.build();
    }

    protected CoordinatorCourseDTO coordinatorCourseToCoordinatorCourseDTO(CoordinatorCourse coordinatorCourse) {
        if ( coordinatorCourse == null ) {
            return null;
        }

        CoordinatorCourseDTOBuilder coordinatorCourseDTO = CoordinatorCourseDTO.builder();

        coordinatorCourseDTO.id( coordinatorCourse.getId() );
        coordinatorCourseDTO.name( coordinatorCourse.getName() );

        return coordinatorCourseDTO.build();
    }
}
