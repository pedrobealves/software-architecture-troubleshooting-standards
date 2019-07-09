package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceDTO;
import br.edu.utfpr.troubleshootingstandards.dto.AttendanceStudentDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ClassCourseDTO;
import br.edu.utfpr.troubleshootingstandards.dto.CoordinatorCourseDTO;
import br.edu.utfpr.troubleshootingstandards.dto.DepartmentDTO;
import br.edu.utfpr.troubleshootingstandards.dto.DepartmentLeaderDTO;
import br.edu.utfpr.troubleshootingstandards.dto.LecturerDTO;
import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ReasonDTO;
import br.edu.utfpr.troubleshootingstandards.dto.StudentDTO;
import br.edu.utfpr.troubleshootingstandards.dto.SubjectDTO;
import br.edu.utfpr.troubleshootingstandards.model.Anticipation;
import br.edu.utfpr.troubleshootingstandards.model.ApprovalAnticipation;
import br.edu.utfpr.troubleshootingstandards.model.Attendance;
import br.edu.utfpr.troubleshootingstandards.model.AttendanceStudent;
import br.edu.utfpr.troubleshootingstandards.model.ClassCourse;
import br.edu.utfpr.troubleshootingstandards.model.CoordinatorCourse;
import br.edu.utfpr.troubleshootingstandards.model.Department;
import br.edu.utfpr.troubleshootingstandards.model.DepartmentLeader;
import br.edu.utfpr.troubleshootingstandards.model.Lecturer;
import br.edu.utfpr.troubleshootingstandards.model.Lesson;
import br.edu.utfpr.troubleshootingstandards.model.Modalitie;
import br.edu.utfpr.troubleshootingstandards.model.ProposalAnticipation;
import br.edu.utfpr.troubleshootingstandards.model.Reason;
import br.edu.utfpr.troubleshootingstandards.model.ReasonBy;
import br.edu.utfpr.troubleshootingstandards.model.Student;
import br.edu.utfpr.troubleshootingstandards.model.Subject;
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
        approvalAnticipation.setDepartmentLeader( departmentLeaderDTOToDepartmentLeader( approvalAnticipationDTO.getDepartmentLeader() ) );
        approvalAnticipation.setCoordinatorCourse( coordinatorCourseDTOToCoordinatorCourse( approvalAnticipationDTO.getCoordinatorCourse() ) );
        approvalAnticipation.setConsents( attendanceStudentDTOToAttendanceStudent( approvalAnticipationDTO.getConsents() ) );
        approvalAnticipation.setApproved( approvalAnticipationDTO.isApproved() );

        return approvalAnticipation;
    }

    @Override
    public ApprovalAnticipationDTO toApprovalAnticipationDTO(ApprovalAnticipation approvalAnticipation) {
        if ( approvalAnticipation == null ) {
            return null;
        }

        ApprovalAnticipationDTO approvalAnticipationDTO = new ApprovalAnticipationDTO();

        approvalAnticipationDTO.setId( approvalAnticipation.getId() );
        approvalAnticipationDTO.setProposalAnticipation( proposalAnticipationToProposalAnticipationDTO( approvalAnticipation.getProposalAnticipation() ) );
        approvalAnticipationDTO.setConsents( attendanceStudentToAttendanceStudentDTO( approvalAnticipation.getConsents() ) );
        approvalAnticipationDTO.setDepartmentLeader( departmentLeaderToDepartmentLeaderDTO( approvalAnticipation.getDepartmentLeader() ) );
        approvalAnticipationDTO.setCoordinatorCourse( coordinatorCourseToCoordinatorCourseDTO( approvalAnticipation.getCoordinatorCourse() ) );
        approvalAnticipationDTO.setApproved( approvalAnticipation.isApproved() );

        return approvalAnticipationDTO;
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

        Reason reason = new Reason();

        if ( reasonDTO.getReasonBy() != null ) {
            reason.setReasonBy( Enum.valueOf( ReasonBy.class, reasonDTO.getReasonBy() ) );
        }
        reason.setDescription( reasonDTO.getDescription() );

        return reason;
    }

    protected Anticipation anticipationDTOToAnticipation(AnticipationDTO anticipationDTO) {
        if ( anticipationDTO == null ) {
            return null;
        }

        Anticipation anticipation = new Anticipation();

        anticipation.setReason( reasonDTOToReason( anticipationDTO.getReason() ) );
        if ( anticipationDTO.getModalitie() != null ) {
            anticipation.setModalitie( Enum.valueOf( Modalitie.class, anticipationDTO.getModalitie() ) );
        }
        anticipation.setNumberClasses( anticipationDTO.getNumberClasses() );
        anticipation.setNextDate( anticipationDTO.getNextDate() );

        return anticipation;
    }

    protected Subject subjectDTOToSubject(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setName( subjectDTO.getName() );

        return subject;
    }

    protected Lecturer lecturerDTOToLecturer(LecturerDTO lecturerDTO) {
        if ( lecturerDTO == null ) {
            return null;
        }

        Lecturer lecturer = new Lecturer();

        lecturer.setName( lecturerDTO.getName() );

        return lecturer;
    }

    protected Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setName( studentDTO.getName() );

        return student;
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

        ClassCourse classCourse = new ClassCourse();

        classCourse.setSubject( subjectDTOToSubject( classCourseDTO.getSubject() ) );
        classCourse.setLecturer( lecturerDTOToLecturer( classCourseDTO.getLecturer() ) );
        classCourse.setStudents( studentDTOSetToStudentSet( classCourseDTO.getStudents() ) );

        return classCourse;
    }

    protected Attendance attendanceDTOToAttendance(AttendanceDTO attendanceDTO) {
        if ( attendanceDTO == null ) {
            return null;
        }

        Attendance attendance = new Attendance();

        attendance.setId( attendanceDTO.getId() );
        attendance.setStudent( studentDTOToStudent( attendanceDTO.getStudent() ) );
        attendance.setPresence( attendanceDTO.isPresence() );

        return attendance;
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

        Lesson lesson = new Lesson();

        lesson.setId( lessonDTO.getId() );
        lesson.setClassCourse( classCourseDTOToClassCourse( lessonDTO.getClassCourse() ) );
        Set<String> set = lessonDTO.getType();
        if ( set != null ) {
            lesson.setType( new HashSet<String>( set ) );
        }
        lesson.setAttendanceStudent( attendanceStudentDTOToAttendanceStudent( lessonDTO.getAttendanceStudent() ) );
        lesson.setContent( lessonDTO.getContent() );
        lesson.setNumberClasses( lessonDTO.getNumberClasses() );
        lesson.setDate( lessonDTO.getDate() );

        return lesson;
    }

    protected ProposalAnticipation proposalAnticipationDTOToProposalAnticipation(ProposalAnticipationDTO proposalAnticipationDTO) {
        if ( proposalAnticipationDTO == null ) {
            return null;
        }

        ProposalAnticipation proposalAnticipation = new ProposalAnticipation();

        proposalAnticipation.setId( proposalAnticipationDTO.getId() );
        proposalAnticipation.setAnticipation( anticipationDTOToAnticipation( proposalAnticipationDTO.getAnticipation() ) );
        proposalAnticipation.setLesson( lessonDTOToLesson( proposalAnticipationDTO.getLesson() ) );

        return proposalAnticipation;
    }

    protected Department departmentDTOToDepartment(DepartmentDTO departmentDTO) {
        if ( departmentDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.setName( departmentDTO.getName() );

        return department;
    }

    protected DepartmentLeader departmentLeaderDTOToDepartmentLeader(DepartmentLeaderDTO departmentLeaderDTO) {
        if ( departmentLeaderDTO == null ) {
            return null;
        }

        DepartmentLeader departmentLeader = new DepartmentLeader();

        departmentLeader.setName( departmentLeaderDTO.getName() );
        departmentLeader.setDepartment( departmentDTOToDepartment( departmentLeaderDTO.getDepartment() ) );

        return departmentLeader;
    }

    protected CoordinatorCourse coordinatorCourseDTOToCoordinatorCourse(CoordinatorCourseDTO coordinatorCourseDTO) {
        if ( coordinatorCourseDTO == null ) {
            return null;
        }

        CoordinatorCourse coordinatorCourse = new CoordinatorCourse();

        coordinatorCourse.setName( coordinatorCourseDTO.getName() );

        return coordinatorCourse;
    }

    protected ReasonDTO reasonToReasonDTO(Reason reason) {
        if ( reason == null ) {
            return null;
        }

        ReasonDTO reasonDTO = new ReasonDTO();

        if ( reason.getReasonBy() != null ) {
            reasonDTO.setReasonBy( reason.getReasonBy().name() );
        }
        reasonDTO.setDescription( reason.getDescription() );

        return reasonDTO;
    }

    protected AnticipationDTO anticipationToAnticipationDTO(Anticipation anticipation) {
        if ( anticipation == null ) {
            return null;
        }

        AnticipationDTO anticipationDTO = new AnticipationDTO();

        anticipationDTO.setReason( reasonToReasonDTO( anticipation.getReason() ) );
        if ( anticipation.getModalitie() != null ) {
            anticipationDTO.setModalitie( anticipation.getModalitie().name() );
        }
        anticipationDTO.setNumberClasses( anticipation.getNumberClasses() );
        anticipationDTO.setNextDate( anticipation.getNextDate() );

        return anticipationDTO;
    }

    protected SubjectDTO subjectToSubjectDTO(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setName( subject.getName() );

        return subjectDTO;
    }

    protected LecturerDTO lecturerToLecturerDTO(Lecturer lecturer) {
        if ( lecturer == null ) {
            return null;
        }

        LecturerDTO lecturerDTO = new LecturerDTO();

        lecturerDTO.setName( lecturer.getName() );

        return lecturerDTO;
    }

    protected StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setName( student.getName() );

        return studentDTO;
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

        ClassCourseDTO classCourseDTO = new ClassCourseDTO();

        classCourseDTO.setSubject( subjectToSubjectDTO( classCourse.getSubject() ) );
        classCourseDTO.setLecturer( lecturerToLecturerDTO( classCourse.getLecturer() ) );
        classCourseDTO.setStudents( studentSetToStudentDTOSet( classCourse.getStudents() ) );

        return classCourseDTO;
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

        AttendanceStudentDTO attendanceStudentDTO = new AttendanceStudentDTO();

        if ( attendanceStudent.getId() != null ) {
            attendanceStudentDTO.setId( attendanceStudent.getId() );
        }
        attendanceStudentDTO.setAttendance( attendanceSetToAttendanceDTOSet( attendanceStudent.getAttendance() ) );
        attendanceStudentDTO.setNote( attendanceStudent.getNote() );
        attendanceStudentDTO.setCreatedAt( attendanceStudent.getCreatedAt() );

        return attendanceStudentDTO;
    }

    protected LessonDTO lessonToLessonDTO(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setId( lesson.getId() );
        lessonDTO.setClassCourse( classCourseToClassCourseDTO( lesson.getClassCourse() ) );
        Set<String> set = lesson.getType();
        if ( set != null ) {
            lessonDTO.setType( new HashSet<String>( set ) );
        }
        lessonDTO.setAttendanceStudent( attendanceStudentToAttendanceStudentDTO( lesson.getAttendanceStudent() ) );
        lessonDTO.setContent( lesson.getContent() );
        lessonDTO.setNumberClasses( lesson.getNumberClasses() );
        lessonDTO.setDate( lesson.getDate() );

        return lessonDTO;
    }

    protected ProposalAnticipationDTO proposalAnticipationToProposalAnticipationDTO(ProposalAnticipation proposalAnticipation) {
        if ( proposalAnticipation == null ) {
            return null;
        }

        ProposalAnticipationDTO proposalAnticipationDTO = new ProposalAnticipationDTO();

        if ( proposalAnticipation.getId() != null ) {
            proposalAnticipationDTO.setId( proposalAnticipation.getId() );
        }
        proposalAnticipationDTO.setAnticipation( anticipationToAnticipationDTO( proposalAnticipation.getAnticipation() ) );
        proposalAnticipationDTO.setLesson( lessonToLessonDTO( proposalAnticipation.getLesson() ) );

        return proposalAnticipationDTO;
    }

    protected DepartmentDTO departmentToDepartmentDTO(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setName( department.getName() );

        return departmentDTO;
    }

    protected DepartmentLeaderDTO departmentLeaderToDepartmentLeaderDTO(DepartmentLeader departmentLeader) {
        if ( departmentLeader == null ) {
            return null;
        }

        DepartmentLeaderDTO departmentLeaderDTO = new DepartmentLeaderDTO();

        departmentLeaderDTO.setName( departmentLeader.getName() );
        departmentLeaderDTO.setDepartment( departmentToDepartmentDTO( departmentLeader.getDepartment() ) );

        return departmentLeaderDTO;
    }

    protected CoordinatorCourseDTO coordinatorCourseToCoordinatorCourseDTO(CoordinatorCourse coordinatorCourse) {
        if ( coordinatorCourse == null ) {
            return null;
        }

        CoordinatorCourseDTO coordinatorCourseDTO = new CoordinatorCourseDTO();

        coordinatorCourseDTO.setName( coordinatorCourse.getName() );

        return coordinatorCourseDTO;
    }
}
