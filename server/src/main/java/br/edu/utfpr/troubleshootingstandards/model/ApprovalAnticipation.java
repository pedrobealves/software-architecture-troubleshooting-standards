package br.edu.utfpr.troubleshootingstandards.model;

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

    @OneToOne(cascade = CascadeType.ALL)
    private AttendanceStudent consents;

    private boolean approved;
}
