package br.edu.utfpr.troubleshootingstandards.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprovalAnticipationDTO {
    private Long id;
    private ProposalAnticipationDTO proposalAnticipation;
    private AttendanceStudentDTO consents;
    private DepartmentLeaderDTO departmentLeader;
    private CoordinatorCourseDTO coordinatorCourse;
    private boolean approved;
}
