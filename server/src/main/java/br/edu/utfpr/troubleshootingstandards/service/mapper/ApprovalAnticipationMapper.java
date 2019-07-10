package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.model.ApprovalAnticipation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface ApprovalAnticipationMapper {
    @Mappings({
            @Mapping(target = "departmentLeader", ignore = true),
            @Mapping(target = "coordinatorCourse", ignore = true),
            @Mapping(target = "approved", ignore = true)
    })
    ApprovalAnticipation toApprovalAnticipation(ApprovalAnticipationDTO approvalAnticipationDTO);
    ApprovalAnticipationDTO toApprovalAnticipationDTO(ApprovalAnticipation approvalAnticipation);
    List<ApprovalAnticipationDTO> toApprovalAnticipationDTO(List<ApprovalAnticipation> approvalAnticipationDTO);
}
