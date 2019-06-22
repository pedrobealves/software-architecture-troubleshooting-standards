package br.edu.utfpr.troubleshootingstandards.model;

import br.edu.utfpr.troubleshootingstandards.dto.CoordinatorCourseDTO;
import br.edu.utfpr.troubleshootingstandards.dto.DepartmentLeaderDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ApprovalAnticipation implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private ProposalAnticipation proposalAnticipation;

    @ManyToOne
    private DepartmentLeader departmentLeader;

    @ManyToOne
    private CoordinatorCourse coordinatorCourse;

    private boolean approved;
}
