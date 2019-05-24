package br.edu.utfpr.troubleshootingstandards.model;
// acho que as importação do pacote DTO foram desnecessárias já que não são utilizadas neste arquivo
import br.edu.utfpr.troubleshootingstandards.dto.CoordinatorCourseDTO;
import br.edu.utfpr.troubleshootingstandards.dto.DepartmentLeaderDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import lombok.AllArgsConstructor; // acho que simplesmente escrever lombok.* seria bom pra reduzir linha de código com importação
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
