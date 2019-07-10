package br.edu.utfpr.troubleshootingstandards.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ApprovalAnticipation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @OneToOne
    private ProposalAnticipation proposalAnticipation;

    @ManyToOne
    private DepartmentLeader departmentLeader;

    @ManyToOne
    private CoordinatorCourse coordinatorCourse;

    @NotNull
    @OneToOne
    private AttendanceStudent consents;

    private boolean approved;
}
