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
    private long id;
    private ProposalAnticipationDTO proposalAnticipationDTO;
    private DepartmentLeaderDTO departmentLeader;
    private CoordinatorCourseDTO coordinatorCourse;
    private boolean approved;
}
