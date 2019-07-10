package br.edu.utfpr.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprovalAnticipation {
    private Long id;
    private ProposalAnticipation proposalAnticipation;
    private AttendanceStudent consents;
    private DepartmentLeader departmentLeader;
    private CoordinatorCourse coordinatorCourse;
    private boolean approved;
}
